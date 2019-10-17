package action;

import POJO.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;
import java.util.Map;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
    @Resource
    private UserService userService ;
    private UserEntity user ;

    public UserEntity getUser(){return  user;}

    public void setUser(UserEntity user){this.user=user;}

    public String login(){
        if(userService.login(user)){
            Map session = ActionContext.getContext().getSession();
            session.put("user",user);
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
}
