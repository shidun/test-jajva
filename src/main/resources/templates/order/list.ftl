<html>
    <#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">
    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid"    >
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>订单Id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTOPage.content as orderDTO>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.buyerName}</td>
                                <td>${orderDTO.buyerPhone}</td>
                                <td>${orderDTO.buyerAdress}</td>
                                <td>${orderDTO.orderAmout}</td>
                                <td>${orderDTO.orderStatusEnum.msg}</td>
                                <td>${orderDTO.payStatusEnum.msg}</td>
                                <td>${orderDTO.createTime}</td>
                                <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                                <td>
                                    <#if orderDTO.orderStatusEnum.msg == "新订单">
                                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                    </#if>
                                </td>
                            </tr>
                        </#list>

                        </tbody>
                    </table>
                    <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="#">上一页</a></li>
                            <#else >
                                <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..orderDTOPage.totalPages as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index} </a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte orderDTOPage.totalPages>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else >
                                <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">上一页</a></li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket('ws://127..0.1:8080/sell/webSocket');
    } else {
        alert("该浏览器不支持websocket");
    }
    websocket.onopen = function (event) {
        console.log("进入链接");
    }
    websocket.onclose = function (event) {
        console.log("连接关闭！")
    }
    websocket.onmessage = function (event) {
        console.log("收到消息：" + event.data)
        //弹窗提醒，播放音乐
    }
    websocket.onerror = function () {
        alert("websocket通信发生错误!")
    }
    //在浏览器关闭之前 关闭websocket
    window.onbeforeunload = function () {
        websocket.close();
    }
</script>
</body>
</html>
<#--<#list orderDTOPage.content as orderDTO>-->
    <#--${orderDTO.orderId}<br>-->
<#--</#list>-->
