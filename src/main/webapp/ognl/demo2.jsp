<%--
  Created by IntelliJ IDEA.
  User: sunyunfeng
  Date: 2019/10/12
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>ognlDemo2Action</title>
</head>
<body>
<%
    request.setAttribute("name","<font color='red'>haha</font>");
%>
<%-- default 没取到值则为 此处值；
escape 属性为  是否 将html标签和特殊字符进行转义 如双引号会转义为&quot
    此处转义 就是 将上面 内容 原封不动 输出
    todo false 则 输出 效果 红色的haha
 --%>
    <s:property value="#request.name" default="没有取到值" escape="false" /><br>
<%--s:set 将指定值放入指定域  scope 放入到的域 request response application
todo requestTom中得加单引号，否则会被当成ognl表达式解析，最终没结果--%>
    <s:set var="name" value="'requestTom'" scope="request" /><br>
    <s:property value="#request.name" default="没有取到值" escape="false" /><br>

<%--s:push 压栈标签，临时压入值栈，标签结束后会自动删除  属性默认取栈顶值，即此处设置的值--%>
    <s:push value="'valueStackTom'">
        <s:property/>
    </s:push><br>
    <%--s:url namespace action 必加 其他选加
    http://localhost:8080/validate/Demo1Action_add!add.do?name=paramTom
     forceAddSchemeHostAndPort 生成的url是否加上 http://localhost:8080
    method  尾部加上 !add.do
    todo var  与url 结合为key value 加入到ActionContext中
    param 给url加上参数 ?name=paramTom
     --%>
<s:url namespace="/validate" action="Demo1Action_add" forceAddSchemeHostAndPort="true" method="add" var="testUrl">
    <s:param name="name" value="'paramTom'"></s:param>
</s:url>
    <s:property value="#testUrl"/><br>
    <%--这样写先从valueStack 上到下找，找不到会继续到actioncontext中查找--%>
    <s:property value="testUrl"/>
<hr>
<s:a action="Demo1Action" namespace="/ognl">
    <s:param name="name">atom</s:param>
    点我下载汤姆猫🐱</s:a>
    <s:debug></s:debug>
</body>
</html>
