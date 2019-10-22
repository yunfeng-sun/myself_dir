<%--
  Created by IntelliJ IDEA.
  User: sunyunfeng
  Date: 2019/10/21
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<%-- 提交多个文件  这里为3个文件 => 对应的Action中file改为数组 --%>
    <s:form action="Demo2Action.action" namespace="/upload" enctype="multipart/form-data" method="POST">
        <s:file name="file" label="文件上传"/>
        <s:file name="file" label="文件上传"/>
        <s:file name="file" label="文件上传"/>
        <s:submit value="上传"/>
    </s:form>
    <%--通过 debug 标签 查看报错信息（找到错误信息的key）  ACTIONERROR显示错误信息    注意xml中错误页面配置的与success的jsp一致--%>
    <s:actionerror/>
    <s:debug/>
</body>
</html>
