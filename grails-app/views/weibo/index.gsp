<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/8/2 0002
  Time: 8:45
--%>

<%@ page import="java.text.SimpleDateFormat" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>TOP 20</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li>
            <a class="home" href="/idea1/">Home</a>
        </li>
        <li>
            <a class="list" href="/idea1/weibo/refreshData">Refresh Data</a>
        </li>
    </ul>
</div>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>序号</th>
        <th>用户</th>
        <th>地址</th>
        <th>签名</th>
        <th>发布时间</th>
        <th>内容</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${mesgList}" status="i" var="item">
        <tr>
            <td>${i + 1}</td>
            <td>${item.user.name}&nbsp;</td>
            <td>${item.user.location}&nbsp;</td>
            <td>${item.user.description}&nbsp;</td>
            <td>${new SimpleDateFormat("yyyy-MM-dd").format(new Date(item.created_at))}&nbsp;</td>
            <td>${item.text}&nbsp;</td>
        </tr>
    </g:each>
    </tbody>
</table>
<div id="page" pageCount="${page.pageCount}" pageNum="${page.pageNum}" pageSize="${page.size}" pageLimit="${page.limit}"
     numberOfPage="${page.numberOfPage}">

</div>
<script type="text/javascript">
    $(function () {
        var page = $('#page');
        var options = {
            currentPage: page.attr('pageNum'),
            totalPages: page.attr('pageCount'),
            numberOfPages: page.attr('numberOfPages'),
            pageUrl: function (type, page, current) {
                return "/idea1/weibo/index?p=" + page;
            }
        }
        $('#page').bootstrapPaginator(options);

    })
</script>
</body>
</html>