package ognl.vs;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import ognl.Bean.User;

public class VSInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ac = ActionContext.getContext();
        ValueStack vs =ac.getValueStack();
//        List list = (List) invocation.getInvocationContext().getValueStack();
        Object obj = vs.getRoot().peek(); //放在Root元素中 为list ； 取出栈中第一个对象验证是否为action
        System.out.println("栈顶的对象"+obj);
        //创建user对象 放入栈中
        User u = new User();
        vs.getRoot().push(u); // 现在user对象替代action在栈顶

        return invocation.invoke();
    }
}
