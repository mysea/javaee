<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
     <form action="upload" method="post" enctype="multipart/form-data">
         upload file:<input type="file" name="doc"/>
         <br/>
         <input type="submit" value="upload"/>
     </form>
</body>
</html>
