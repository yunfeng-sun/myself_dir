package ognl.valueStacks;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import ognl.Bean.User;
import ognl.vs.VSInterceptor;

public class Demo1Action extends ActionSupport {
    private String name ;
    private int age ;
//todo http://localhost:8080/valueStacks/Demo1Action.action?name=tom

    /**拦截成功，加入成功，赋值成功
     * 栈顶的对象ognl.valueStacks.Demo1Action@4332baaa
     * action中的name属性值：null
     * user 的 name 属性 ： tom
     * @return
     */
    public String execute(){
        System.out.println("action中的name属性值："+name);
        //获取值栈中User对象的name属性
        ValueStack vs = ActionContext.getContext().getValueStack();
        User u = (User)vs.getRoot().peek();
        System.out.println("user 的 name 属性 ： "+ u.getName()); // 表单中传入的参数 被 自定义的拦截器 加入到 值栈顶的
        return  SUCCESS;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
