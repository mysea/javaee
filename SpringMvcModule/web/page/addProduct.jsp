<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<html>
<head>
    <title>addProduct</title>
</head>
<body>
    <form action="/product/add" method="post">
        name: <input type="text" name="name" value=""/><br/>
        price: <input type="text" name="price" value=""/><br/>
        <input type="submit" value="增加商品"/>
    </form>
</body>
</html>
