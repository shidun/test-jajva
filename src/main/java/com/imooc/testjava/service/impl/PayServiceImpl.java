package com.imooc.testjava.service.impl;

import com.imooc.testjava.dto.OrderDTO;
import com.imooc.testjava.enums.ResultEnum;
import com.imooc.testjava.exception.SellException;
import com.imooc.testjava.service.OrderService;
import com.imooc.testjava.service.PayService;
import com.imooc.testjava.util.JsonUtil;
import com.imooc.testjava.util.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "测试微信订单";
    @Autowired
    private BestPayServiceImpl bestPayService;
    @Autowired
    private OrderService orderService;

    /**
     * 生成预订单
     * @param orderDTO
     * @return
     */
    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmout().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付 request={}", payRequest);
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付 reponse={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    /**
     * 支付成功回调
     * @param notifyData
     * @return
     */
    @Override
    public PayResponse notify(String notifyData) {
        //验证签名
        //支付状态判断
        //支付金额
        //支付人（下单人 == 支付人）

        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信异步通知】 payResponse={}", JsonUtil.toJson(payResponse));

        //查询订单
        OrderDTO orderDTO = orderService.getOne(payResponse.getOrderId());
        if (orderDTO == null) {
            log.error("【微信异步通知】 订单不存在 orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
        //判断金额是否一致(0.10  0.1) 相减小于某个精度则判断相等
//        if (orderDTO.getOrderAmout().compareTo(new BigDecimal(payResponse.getOrderAmount())) != 0) {
        if (!MathUtil.equals(orderDTO.getOrderAmout().doubleValue(), payResponse.getOrderAmount())) {
            log.error("【微信异步通知】 订单金额不一致 orderId={}，微信通知金额={}，系统订单金额={}",
                    payResponse.getOrderId(), payResponse.getOrderAmount(), orderDTO.getOrderAmout());
            throw new SellException(ResultEnum.WX_NOTIFY_AMOUNT);
        }

        //修改订单支付状态
        orderService.paid(orderDTO);
        return payResponse;
    }

    /**
     * 退款
     * @param orderDTO
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmout().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】 refundResponse={}", refundRequest);
        return refundResponse;
    }
}
