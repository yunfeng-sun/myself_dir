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
    request.setAttribute("name","requestTom");  //在request域中放入值
    session.setAttribute("name","sessionTom");
    application.setAttribute("name","applicationTom");
%>
<!--  property  标签中使用ognl表达式
   debug  可以从 值栈 和 ActionContext 查看

    使用ognl取得 上面赋值的三个域的 属性   #为context中取值 ； 值栈中为action的属性
       todo  #后的标签 需要在 debug中含有；
-->
#request.name：<s:property value="#request.name"/><br>
#session.name：<s:property value="#session.name"/><br>
#application.name: <s:property value="#application.name"/><br>
name：<s:property value="name"/>
               <hr>
               <!--  访问action中user的name属性 -->
user.name： <s:property value="user.name"/>
               <hr>
               <!-- 栈顶对象的name属性 现在栈顶为 加入的user对象 -->
name：<s:property value="name" />
               <hr>
               <!-- user为第一个 下标为0，第二个为action  下标为1-->
[1].name：<s:property value="[1].name" />
        <hr>
        <!--  从request中获取值栈  没啥用，这里获取格式不对-->
        <%--<s:property value="#request.struts.valueStack.password"/>--%>
    <s:debug></s:debug>
</body>
</html>
