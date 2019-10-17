<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户验证</title>
</head>
<body>
    <s:form action = "Demo1Action_add.action" namespace="/validate">
        <s:textfield name="name" label="用户名"></s:textfield>
        <s:submit value ="添加"></s:submit>
    </s:form>
</body>
</html>
