<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <s:iterator var="p" value="products">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
        </tr>
    </s:iterator>
</table>
