<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: txin15
  Date: 2017/7/16
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
    <style type="text/css">
        upload {
            font-size: 12px
        }
    </style>
</head>
<body>
    <form:form commandName="file" action="/file/upload" method="post" enctype="multipart/form-data">
        <upload>选择文件&nbsp&nbsp&nbsp&nbsp&nbsp</upload><input type="file" name="file"/>
        <input type="submit" value="Upload"/>
    </form:form>
</body>
</html>
