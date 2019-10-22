<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunyunfeng
  Date: 2019/10/21
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错页面</title>
</head>
<body>
    <form name="Form1" method="post" action="name.aspx" id="Form1">
        <table width="100%" border="0" height="88" border="1" background="<c:url value='/images/back1.JPG'/>">
            <tr>
                <td colspan=3 class="ta_01" align="center" bgcolor="#afd1f3"><strong>出错啦！</strong></td>
            </tr>
            <tr>
                <td width="65%" height="84" align="center" valign="top">
                    <span class="Style1" ><s:property/>
                        <s:debug/>
                    </span>
                </td>
            </tr>
            <tr><td height="2"></td> </tr>
        </table>
    </form>
</body>
</html>