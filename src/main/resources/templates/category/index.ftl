<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">
    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-8 column">
                    <form role="form" action="/sell/seller/category/save" method="post">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="categoryName" type="text" class="form-control" value="${(productCategory.categoryName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>type</label>
                            <input name="categoryType" type="number" class="form-control" value="${(productCategory.categoryType)!''}"/>
                        </div>

                        <input class="hidden" type="text" name="categoryId" value="${(productCategory.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>