package com.imooc.testjava.service.impl;

import com.imooc.testjava.config.WechatAccountConfig;
import com.imooc.testjava.dto.OrderDTO;
import com.imooc.testjava.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WechatAccountConfig accountConfig;

    /**
     * 发送消息到微信
     * {{first.DATA}} 商家名称：{{keyword1.DATA}} 商家电话：{{keyword2.DATA}}
     * 订单号：{{keyword3.DATA}} 状态：{{keyword4.DATA}} 总价：{{keyword5.DATA}} {{remark.DATA}}
     * @param orderId
     */
    @Override
    public void orderStatus(String orderId) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser("oybUM6J4tdDskJihTCMO4TfB8ss4");
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "记得收2获"),
                new WxMpTemplateData("keyword1", "黄焖鸡2"),
                new WxMpTemplateData("keyword2", "18357254652"),
                new WxMpTemplateData("keyword3", "45645613248646"),
                new WxMpTemplateData("keyword4", "已送达"),
                new WxMpTemplateData("keyword5", "20"),
                new WxMpTemplateData("remark", "不加辣啊")
        );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败：{}", e);
        }
    }
}
