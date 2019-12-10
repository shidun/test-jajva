package com.imooc.testjava.controller;

import com.imooc.testjava.VO.BaseShopVo;
import com.imooc.testjava.service.ImportService;
import me.chanjar.weixin.common.api.WxConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : jack sd
 * @date : 2019/12/2
 */
@Controller
public class testController {

    @Autowired
    private ImportService importService;

    //使用第三方sdk
    @GetMapping("/authorize")
    public String authSdk() {
        return "111111" ;
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
    public String exportExcel(HttpServletResponse response) throws Exception {
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
        return "导出成功";
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
