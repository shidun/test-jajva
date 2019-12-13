package com.imooc.testjava.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.internal.util.StreamUtil;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.imooc.testjava.VO.BaseShopVo;
import com.imooc.testjava.config.MyConfig;
import com.imooc.testjava.service.ImportService;
import com.imooc.testjava.util.JsonUtil;
import com.lly835.bestpay.rest.type.Get;
import com.lly835.bestpay.rest.type.Post;
import me.chanjar.weixin.common.api.WxConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : jack sd
 * @date : 2019/12/2
 */
@Controller
public class testController {

    @Value("${aliPay.private_key}")
    private String APP_PRIVATE_KEY;
    @Value("${aliPay.public_key}")
    private String ALIPAY_PUBLIC_KEY;
    @Value("${aliPay.app_ID}")
    private String APP_ID;
    @Value("${aliPay.url}")
    private String URL;
    @Value("${aliPay.current_url}")
    private String current_url;

    private String FORMAT = "json";
    private String CHARSET = "UTF-8";
    private String SIGN_TYPE = "RSA2";

    @Autowired
    private ImportService importService;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(()-> {
                try {
                    Thread.sleep(100);
                    if (index % 3 == 0) {
                        throw new IllegalStateException("Error");
                    }
                    System.out.println(index);
                } catch (Exception e ) {
                }
            });
        }
//        executorService.shutdown();
    }

    //使用第三方sdk
    @GetMapping("/weixinPay")
    @ResponseBody
    public void weixinPay(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                          HttpServletRequest request) throws Exception {
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "测试支付");
        String out_trade_no = getRandId();
        data.put("out_trade_no", out_trade_no);//商户订单号
        data.put("total_fee", "1");
        data.put("spbill_create_ip", request.getRemoteAddr());
        data.put("notify_url", "http://ase42b.natappfree.cc/wxNotify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
//            System.out.println(resp);
            System.out.println(resp.get("code_url"));
            String contents = resp.get("code_url").toString();
            createQR(contents, httpResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //使用第三方sdk
    @RequestMapping("/wxNotify")
    @ResponseBody
    public String wxNotify(HttpServletRequest request) throws Exception {
        System.out.println("-----微信回调-----");
        InputStream in = request.getInputStream();
        BufferedReader br = new BufferedReader( new InputStreamReader( in, "UTF-8" ) );
        StringBuffer result = new StringBuffer();
        String line = "";
        while ( ( line = br.readLine() ) != null )
        {
            result.append(line);
        }
        String notifyData = result.toString(); // 支付结果通知的xml格式数据
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);
        Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData);  // 转换成map
        if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
            System.out.println("签名正确");
            if (notifyMap.get("return_code").equals("SUCCESS") && notifyMap.get("result_code").equals("SUCCESS")) {
                System.out.println("支付成功");
                System.out.println("orderId:" + notifyMap.get("out_trade_no"));
            }
            // 签名正确
            // 进行处理。
            // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
        }
        else {
            System.out.println("签名错误");
            // 签名错误，如果数据里没有sign字段，也认为是签名错误
        }
        return "success";
    }



    //使用第三方sdk
    @GetMapping("/CallBack")
    @ResponseBody
    public Map CallBack(@RequestParam Map<String, String> paramsMap) throws Exception {
        return paramsMap;
    }
    //使用第三方sdk
    @PostMapping("/NotifyUrl")
    @ResponseBody
    public String NotifyUrl(@RequestParam Map<String, String> paramsMap) throws Exception {
        boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE);//调用SDK验证签名
        if(signVerified){
            System.out.println("验签成功后");
            String status = paramsMap.get("trade_status");
            if (status.equals("TRADE_SUCCESS")) {
                //修改订单状态为已完成
                String orderId = paramsMap.get("out_trade_no");
                String total_amount = paramsMap.get("total_amount");
                System.out.println(orderId);
                System.out.println(total_amount);
                System.out.println("订单完成");
            }
            return "success";

        }else{
            System.out.println("验签失败则记录异常日志");
            return "failure";
        }
    }



    //使用第三方sdk
    @GetMapping("/authorize2")
    @ResponseBody
    public void doPost(HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse) throws ServletException, IOException {

        AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(current_url + "/CallBack");
        alipayRequest.setNotifyUrl(current_url + "/NotifyUrl");//在公共参数中设置回跳和通知地址
        Random random = new Random();
        Integer num = random.nextInt(99999) + 100000;
        String out_trade_no = getCurrentDate() + num;
        System.out.println(getCurrentDate());
        System.out.println(num);
        Map content = new HashMap();
        content.put("out_trade_no", out_trade_no);
        content.put("product_code", "FAST_INSTANT_TRADE_PAY");
        content.put("total_amount", 16);
        content.put("subject", "测试商品subject");
        content.put("body", "测试商品body");
        content.put("passback_params", "testback");
        Map map = new HashMap();
        map.put("sys_service_provider_id", "2088511833207846");
        content.put("extend_params", map);
        alipayRequest.setBizContent(JsonUtil.toJson(content));//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    private String getRandId() {
        Random random = new Random();
        Integer num = random.nextInt(99999) + 100000;
        String out_trade_no = getCurrentDate() + num;
        return out_trade_no;
    }
    //使用第三方sdk
    @GetMapping("/authorize3")
    @ResponseBody
    public void doPost2(HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        Random random = new Random();
        Integer num = random.nextInt(99999) + 100000;
        String out_trade_no = getCurrentDate() + num;
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        request.setNotifyUrl(current_url + "/NotifyUrl");//在公共参数中设置回跳和通知地址

        request.setBizContent("{" +
                "    \"out_trade_no\":"+out_trade_no+"," +//商户订单号
                "    \"total_amount\":\"88.88\"," +
                "    \"subject\":\"Iphone6 16G\"," +
//                "    \"store_id\":\"NJ_001\"," +
                "    \"timeout_express\":\"90m\"}");//订单允许的最晚付款时间
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        Map stringToMap =  JSONObject.parseObject(response.getBody());
        Object aa = stringToMap.get("alipay_trade_precreate_response");
        Map stringToMap2 =  JSONObject.parseObject(aa.toString());
        String code = stringToMap2.get("code").toString();
        if (code.equals("20000")) {
            throw new RuntimeException("ali系统繁忙");
        }
        System.out.println(code);
        //根据返回的url生成二维码
        String contents = stringToMap2.get("qr_code").toString();
        createQR(contents, httpResponse);
//        ServletOutputStream out = httpResponse.getOutputStream();
//        try {
//            Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
//            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
//            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//            hints.put(EncodeHintType.MARGIN, 0);
//            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE,300,300,hints);
//            MatrixToImageWriter.writeToStream(bitMatrix,"jpg",out);
//        }catch (Exception e){
//            throw new Exception("生成二维码失败！");
//        }finally {
//            if(out != null){
//                out.flush();
//                out.close();
//            }
//        }
    }

    protected void createQR(String contents, HttpServletResponse httpResponse) throws Exception {
        ServletOutputStream out = httpResponse.getOutputStream();
        try {
            Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE,300,300,hints);
            MatrixToImageWriter.writeToStream(bitMatrix,"jpg",out);
        }catch (Exception e){
            throw new Exception("生成二维码失败！");
        }finally {
            if(out != null){
                out.flush();
                out.close();
            }
        }
    }

    private String getCurrentDate()
    {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    @PostMapping(value = "/uploads")
    @ResponseBody
    public String uploads(HttpServletRequest request) {
        //创建workbook
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("filename");
            if (file.isEmpty()) {
                return "文件不能为空";
            }
            InputStream inputStream = file.getInputStream();
            List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
            inputStream.close();

            for (int i = 0; i < list.size(); i++) {
                List<Object> lo = list.get(i);
                BaseShopVo baseShopVo = new BaseShopVo(lo);
                System.out.println(lo);
            }
        }  catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "上传成功";
    }

    /**
     * 导出excel
     * @param response
     * @throws Exception
     */
    @GetMapping(value = "/exportExcel")
    public void exportExcel(HttpServletResponse response) throws Exception {
//        ConcurrentHashMap
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        CountDownLatch one = new CountDownLatch(1);
        one.countDown();
        one.await();
        List<String> header = new ArrayList<>();
        header.add("评论Id");
        header.add("被评论人Id");
        header.add("内容");
        List<List<String>> dataList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<String> data = new ArrayList<>();
            data.add(i+"id");
            data.add(i+"commented");
            data.add(i+"getContent");
            dataList.add(data);
        }
        try {
            importService.exportExcel(response, "测试", "副标题", header, dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//    public static void main(String[] args) {
//        Executors.newCachedThreadPool();
//
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//        System.out.println(new Date());
////        for (int i = 0; i < 10; i++) {
//            final int index = 1;
//            executorService.scheduleAtFixedRate(() -> {
//                try {
//                    System.out.println(index+"start"+new Date());
//                    Thread.sleep(1000);
//                    System.out.println(index+"end"+new Date());
//                } catch (Exception e) {
//                }
//            }, 5, 3, TimeUnit.SECONDS);
////        }
//
////        executorService.shutdown();
////        try {
////            Thread.sleep(10000);
////        } catch (Exception e) {
////
////        }
//    }

}
