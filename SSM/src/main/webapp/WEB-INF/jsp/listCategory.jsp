<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("#delete").attr("action",href).submit();
            return false;
        })
    })
</script>


<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${categories}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td><a href="/category/${c.id}">编辑</a></td>
            <td><a href="/category/${c.id}" class="delete">删除</a></td>
        </tr>
    </c:forEach>
</table>

<div style="text-align: center">
    <a href="?start=0">首页</a>
    <a href="?start=${page.start-page.count}">上一页</a>
    <a href="?start=${page.start+page.count}">下一页</a>
    <a href="?start=${page.last}">最后一页</a>
</div>

<br/>
<br/>

<div style="text-align: center">
    <form method="post" action="/category">
        <input type="hidden" name="_method" value="PUT"/>
        name：<input name="name" value="" type="text"/>
        <br/><br/>
        <input type="submit" value="增加分类"/>
    </form>
</div>


<form id="delete" action="" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
</form>