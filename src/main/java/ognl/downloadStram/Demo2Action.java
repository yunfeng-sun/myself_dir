package ognl.downloadStram;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import ognl.Bean.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Demo2Action extends ActionSupport {
    private User user = new User("beanTom","1234");
    private String name = "ActionTom";

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() {
        //将user对象压入值栈中，则栈顶为user对象
        ActionContext.getContext().getValueStack().push(user);
        return SUCCESS;
    }
}
