<%--
  Created by IntelliJ IDEA.
  User: sunyunfeng
  Date: 2019/10/17
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script src="${base}/html/js/table/quiGrid.js?ver=${v}" type="text/javascript"></script>--%>
<%--<script src="${base}/html/js/form/form.js?ver=${v}" type="text/javascript"></script>--%>
<%--<script src="${base}/html/js/form/selectTree.js?ver=${v}" type="text/javascript"></script>--%>
<%--<script src="${base}/html/js/form/datePicker/WdatePicker.js?ver=${v}" type="text/javascript"></script>--%>
<%--<script src="${base}/html/js/jquery-extend.js?ver=${v}" type="text/javascript"></script>--%>
<html>
<head>
    <%-----日期转换--%>
    <title>用户信息登记</title>
</head>
<body>
    <form action ="userInfo.action" method ="post">
        姓名：<input type="text" name="name" placeholder="姓名："/>
        年龄：<input type="text" name="age" placeholder="年龄："/>
        性别：<input type="text" name="sex" placeholder="性别："/>
        生日：<input type="date" name="birthday" placeholder="生日："/><br/>
        <input type="submit" value="登录">
        <input type="reset" value="重置"><br/>
        ${result}
    </form>
</body>
</html>
