package com.imooc.testjava.controller;

import com.imooc.testjava.dto.OrderDTO;
import com.imooc.testjava.service.OrderService;
import com.imooc.testjava.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/***
 *  卖家端订单
 */
@Controller
@Slf4j
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;
    /**
     * 订单列表
     * page 第几页
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findAllList(request);
        Map<String, Object> map = new HashMap<>();
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        orderDTOPage.getTotalPages();
        return new ModelAndView("order/list", map);
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.getOne(orderId);
//            log.info(JsonUtil.toJson(orderDTO));
            orderService.cancel(orderDTO);
        } catch (Exception e) {
            log.error("【卖家端取消订单】 查询订单为空");
            map.put("msg", "取消失败");
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", "取消成功");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 订单详情
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String , Object> map) {
        OrderDTO orderDTO = orderService.getOne(orderId);
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String , Object> map) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.getOne(orderId);
            orderService.finish(orderDTO);
        } catch (Exception e) {
            log.error("【卖家端完结订单】错误");
            map.put("msg", "完结失败");
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", "完结订单");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
