<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/8/2 0002
  Time: 8:45
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>TOP 20</title>
    <meta name="layout" content="main" />
</head>

<body>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
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
            <td>${item.user.name}&nbsp;</td>
            <td>${item.user.location}&nbsp;</td>
            <td>${item.user.description}&nbsp;</td>
            <td>${item.created_at}&nbsp;</td>
            <td>${item.text}&nbsp;</td>
        </tr>
    </g:each>
    </tbody>
</table>
<ul class="pager">
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
</ul>
</body>
</html>