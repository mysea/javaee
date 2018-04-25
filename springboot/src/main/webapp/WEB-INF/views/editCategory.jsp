<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div align="center">
    <form action="/category/update" method="post">
        name:<input name="name" value="${c.name}"/><br/><br/>
        <input name="id" type="hidden" value="${c.id}"/>
        <button type="submit">提交</button>
    </form>
</div>