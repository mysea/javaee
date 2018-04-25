<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<s:head/>

<%--<form action="addProduct">--%>
    <%--<input type="text" name="product.name" value="${param.name}"/>--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--<input type="text" name="product.price"/>--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--<input type="submit" value="submit">--%>
<%--</form>--%>

<s:form action="addProduct">
    <s:textfield name="product.name" label="product name"/>
    <s:submit value="submit"/>
</s:form>
</html>
