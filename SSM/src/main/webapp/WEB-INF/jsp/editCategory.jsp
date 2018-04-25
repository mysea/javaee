<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="text-align: center">
    <div>
        <form method="post" action="/category/${c.id}">
            name:<input name="name" value="${c.name}" type="text"/>
            <br/><br/>
            <input type="submit" value="修改分类"/>
        </form>
    </div>
</div>