<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>

${date}

<table border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>products</td>
    </tr>
    <s:iterator var="c" value="categories">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>
                <s:iterator value="#c.products" var="p">
                    ${p.name}<br/>
                </s:iterator>
            </td>
        </tr>
    </s:iterator>
</table>

<s:debug/>