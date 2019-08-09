<html>
    <head>
        <meta charset="utf-8">
        <title>卖家商品列表</title>
        <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-bordered">
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
</body>
</html>
<#--<#list orderDTOPage.content as orderDTO>-->
    <#--${orderDTO.orderId}<br>-->
<#--</#list>-->
