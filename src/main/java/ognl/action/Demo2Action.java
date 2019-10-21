package ognl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ognl.Bean.User;

public class Demo2Action extends ActionSupport
{
    private User user = new User() ;
    public String execute(){
//        http://localhost:8080/valueStacks/Demo2Action.do?user.name=tom   ognl表达式赋值
        System.out.println(user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getModel() {  //已存在的拦截器  ModelDrivenInterceptor (实现了ModelDriven接口，强转为ModelDriven，加入到栈顶)
        //        http://localhost:8080/valueStacks/Demo2Action.do?name=tom   将user加入到栈顶
         return user;
    }
}
