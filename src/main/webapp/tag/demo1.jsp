<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <style type="text/css">
        .add{
            background-color: red;
        }
        .even{
            background-color: blue;
        }
    </style>
</head>
<body>
<%
    request.setAttribute("num1",100);
    request.setAttribute("num2",200);
%>
<%--s:if  true时才显示值 false啥都没，不占行--%>
    <s:if test="#request.num1> #request.num2">num1大</s:if>
    <s:else>
        num2大
    </s:else>
<hr>
    <%--s:iterator--%>
<%
    List<String> list = new ArrayList<>();
    list.add("tom");
    list.add("jerry");
    list.add("jack");
    list.add("rose"); session.setAttribute("list",list);
%>
<%-- var  给list每个元素都加入key   这里加入表中  tr 表头  th 行
   todo var  将每次遍历的压入ActionContext    debug的 session域	{list=[tom, jerry, jack, rose]}
   todo   status="st"   状态作为键放入Actioncontexy中  调用的是 方法--%>
<table border="1">
    <tr>
        <th>用户名</th>
        <th>遍历计数</th>
        <th>遍历索引</th>
        <th>是否是双数</th>
        <th>是否是单数</th>
        <th>是否是第一个</th>
        <th>是否是最后一个</th>
    </tr>
    <s:iterator value="#session.list" var="name" status="st">
        <tr class='<s:property value="#st.even==true?'even':'add'"/>' >
            <td><s:property/></td>
            <td><s:property value="#st.count"/></td>
            <td><s:property value="#st.index"/></td>
            <td><s:property value="#st.even"/></td>
            <td><s:property value="#st.odd"/></td>
            <td><s:property value="#st.first"/></td>
            <td><s:property value="#st.last"/></td>
        </tr>
    </s:iterator>
</table>
<s:iterator begin="1" end="10" step="1" var="num">
    <s:property/><br/>
</s:iterator>
    <s:debug></s:debug>
</body>
</html>


