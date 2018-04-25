<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadImage</title>
</head>
<body>
    <form action="/image/upload" method="post" enctype="multipart/form-data">
        选择图片：<input type="file" name="image" accept="image/*"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
