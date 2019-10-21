package ognl;

import ognl.Bean.Address;
import ognl.Bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//todo 取值 / 赋值 / 调用方法(普通与静态) / 创建 list  map 自定义对象 / in not in / 投影 / 过滤
//ognl的基本使用 => 以 视图得方式取值 a.b.c(层级关系)
// context取值/赋值 用# （投影也是# 从context中取值，而不是list对象的this来拿名为name的属性值）； 静态方法或变量 @
// 支持算术运算符 直接填写即可
// 多个表达式 用 逗号 ， 连接  ; 但返回结果只为 最后一个表达式结果
public class Demo {

    @Test
    public void fun1() throws OgnlException {
        //3方法的重载 参数1--填写ognl表达式
        // 参数2 Map =》 context上下文   从context中取对值 (是个Map)
        // 参数3 javaBean / list /Map ... (从第三个参数中取对象) 叫做根 root
        User u = new User(); //是个对象，则放入第三个参数中
        u.setName("tom");
        String name = (String) Ognl.getValue("name",new HashMap(),u); // context为空，从根下取出 名为name属性的值
        System.out.println(name);
    }
    @Test
    public void fun2() throws OgnlException {
        //3方法的重载 参数1--填写ognl表达式
        // 参数2 Map =》 context上下文   从context中取对值 (是个Map)
        // 参数3 javaBean / list /Map ... (从第三个参数中取对象) 叫做根 root
        List<User> list = new ArrayList<User>(); //list 放入第三个参数中
        User u1 = new User();
        u1.setName("tom");
        list.add(u1);
        User u2 = new User();
        u2.setName("jerry");
        list.add(u2);
        //todo ognl 默认从根下取数据                   list的下标
        String name = (String) Ognl.getValue("[1].name",new HashMap(),list); // context为空，从根下取出 us1的 ame属性的值
        System.out.println(name);
    }
    @Test
    public void fun3() throws OgnlException {
        //3方法的重载 参数1--填写ognl表达式
        // 参数2 Map =》 context上下文   从context中取对值 (是个Map)
        // 参数3 javaBean / list /Map ... (从第三个参数中取对象) 叫做根 root
        Map<String,Object> context = new HashMap<String, Object>();
        context.put("name","tom");
        User u = new User();
        u.setName("jerry");
        //todo #表示从context中取 tom ; 没#号 则从对象中取 jerry 此时格式得与fun1 一致
        String name = (String) Ognl.getValue("#name",context,new Object()); // context为空，从根下取出 us1的 ame属性的值
        System.out.println(name);
    }
    @Test
    public void fun4() throws OgnlException {
        User u = new User();
        u.setName("jerry");
        Address address = new Address();
        address.setCity("北京1");
        u.setAddress(address);
        String city = (String) Ognl.getValue("address.city",new HashMap(),u);
        System.out.println(city);
    }

    // 使用表达式赋值
    @Test
    public void fun5() throws OgnlException {
        User u = new User();
        //用 get 赋值
        Ognl.getValue("name='tom'",new HashMap(),u);
        System.out.println(u.getName());
    }
    @Test
    public void fun6() throws OgnlException {
        User u = new User();
        //用 set 赋值
        Ognl.setValue("name",new HashMap(),u,"jerry");
        System.out.println(u.getName());
    }
    @Test
    public void fun7() throws OgnlException {
        User u = new User();
        //用 get 赋值 ==> 使用user对象内的方法（没加# -->则必须存在于根对象）
        Ognl.getValue("setName('jack')",new HashMap(),u);
        System.out.println(u.getName());
    }
    @Test
    public void fun8() throws OgnlException {
        // 静态方法调用(不限于必须在根对象中) 使用@ 引用静态方法或静态变量
        User u = new User();
        //用 get 赋值 ==> 使用user对象内的方法（没加# -->则必须存在于根对象）
        String time = (String)Ognl.getValue("@ognl.Bean.DateUtils@getTime()",new HashMap(),u);
        String echo = (String)Ognl.getValue("@ognl.Bean.DateUtils@echo('ads')",new HashMap(),u);
        System.out.println(time);
        System.out.println(echo);
    }
    @Test
    public void fun9() throws OgnlException {
        // 静态变量调用
        User u = new User();
        double PI = (Double)Ognl.getValue("@ognl.Bean.DateUtils@PI",new HashMap(),u);
        System.out.println(PI);
    }
    @Test
    public void fun10() throws OgnlException {
        // 支持算数运算符
        User u = new User();
        int result = (Integer) Ognl.getValue("1+1",new HashMap(),u);
        System.out.println(result);
    }
    @Test
    public void fun11() throws OgnlException {
        // 并联 逗号 连接
        User u = new User();
        //todo 并连 只返回最后一个表达式结果
        String result = (String) Ognl.getValue("name='tom',1+2,name='jerry'",new HashMap(),u);
        System.out.println(result); //todo jerry
    }
    @Test
    public void fun12() throws OgnlException {
        User u = new User();
        //todo 创建一个对象 list map(map用#标识)  创建 User对象
        List list = (List) Ognl.getValue("{'tom','jerry','jack','rose'}",new HashMap(),u);
        Map map = (Map) Ognl.getValue("#{'name':'tom','age':'18'}",new HashMap(),u);
        User u1 = (User) Ognl.getValue("new ognl.Bean.User()",new HashMap(),u);
        System.out.println(list); // [tom, jerry, jack, rose]
        System.out.println(map); // {name=tom, age=18}
        System.out.println(u1); //User{name='null', password='null', address=null}
    }
    @Test
    public void fun13() throws OgnlException {
     // in  /  not in
        User u = new User();
        //判断 tom 是否在后面的集合之内
        boolean result = (Boolean) Ognl.getValue("'tom' in {'tom','jerry','jack','rose'}",new HashMap(),u);
        boolean result1 = (Boolean) Ognl.getValue("'tom' not in {'tom','jerry','jack','rose'}",new HashMap(),u);
        System.out.println(result);
        System.out.println(result1);
    }
    @Test
    public void fun14() throws OgnlException {
        // 集合的投影  ==> 得到所有list中User的 name 的值
        List<User> list = new ArrayList<User>();
        User u = new User();
        u.setName("tom");
        list.add(u);
        User u1 = new User();
        u1.setName("jerry");
        list.add(u1);
        System.out.println(Ognl.getValue("#this.{name}",new HashMap(),list)); //[tom, jerry]
    }
    @Test
    public void fun15() throws OgnlException {
        // 集合的过滤   过滤出成年的
        List<User> list = new ArrayList<User>();
        User u = new User();
        u.setName("tom");
        u.setAge(10);
        list.add(u);
        User u1 = new User();
        u1.setName("jerry");
        u1.setAge(20);
        list.add(u1);
        System.out.println(Ognl.getValue("#this.{?age > 18}",new HashMap(),list)); //[User{name='jerry'age='20', password='null', address=null}]
    }
}
