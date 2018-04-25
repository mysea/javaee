<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
table {
    border-collapse: collapse;
}
td{
    border: 1px solid gray;
}
</style>

<table align="center">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>当前行号（基0）</td>
        <td>当前行号（基1）</td>
        <td>是否是第一个元素</td>
        <td>是否是最后一个元素</td>
        <td>是否是奇数</td>
        <td>是否是偶数</td>
    </tr>
    <s:iterator value="products" var="p" status="st">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${st.index}</td>
            <td>${st.count}</td>
            <td>${st.first}</td>
            <td>${st.last}</td>
            <td>${st.odd}</td>
            <td>${st.even}</td>
        </tr>
    </s:iterator>
</table>

<s:checkboxlist value="selectedProducts" list="products" listValue="name" listKey="id" name="product.id"/>

<br/>
<br/>

<s:radio name="product.id" value="2" list="products" listValue="name" listKey="id"/>

<br/>
<br/>

<s:select label="products" list="products" name="product.id" listValue="name" listKey="id" multiple="true" size="5" value="selectedProducts"/>

<%--<table align="center">--%>
    <%--<tr>--%>
        <%--<td>id</td>--%>
        <%--<td>name</td>--%>
        <%--<td>products</td>--%>
    <%--</tr>--%>
    <%--<s:iterator value="categories" var="c">--%>
        <%--<tr>--%>
            <%--<td>${c.id}</td>--%>
            <%--<td>${c.name}</td>--%>
            <%--<td>--%>
                <%--<s:iterator value="#c.products" var="p">--%>
                    <%--${p.name}<br/>--%>
                <%--</s:iterator>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</s:iterator>--%>
<%--</table>--%>



<s:debug/>






