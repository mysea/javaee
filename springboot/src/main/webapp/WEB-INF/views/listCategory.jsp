<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${page.list}" varStatus="st" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td><a href="/category/get?id=${c.id}">编辑</a></td>
            <td><a href="/category/delete?id=${c.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<div align="center">
    <a href="?start=0">首页</a>
    <a href="?start=${page.pageNum-1}">上一页</a>
    <a href="?start=${page.pageNum+1}">下一页</a>
    <a href="?start=${page.pages}">最后一页</a>

    <form action="/category/add" method="post">
        name:<input name="name"/><br>
        <button type="submit">提交</button>
    </form>
</div>













