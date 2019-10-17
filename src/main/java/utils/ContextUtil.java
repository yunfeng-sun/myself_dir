package utils;

import POJO.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ContextUtil {
    private static final String SESSION_KEY = UserEntity.class.getName();

    private static HttpSession getSession() {
        try {
            HttpServletRequest request = getRequest();
            if (request != null) {
                return request.getSession();
            }
        } catch (Exception var1) {
            ;
        }

        return null;
    }
    private static HttpServletRequest getRequest() {
        try {
            ActionContext actionContext = ActionContext.getContext();
            if (actionContext != null) {
                return ServletActionContext.getRequest();
            }
        } catch (Exception var2) {
            ;
        }
 // 这获取方式 似乎麻烦了吧
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes != null) {
                return ((ServletRequestAttributes)requestAttributes).getRequest();
            }
        } catch (Exception var1) {
            ;
        }

        return null;
    }

    public static UserEntity getCurrentUser(){
        HttpSession session = getSession();
        return getCurrentUser(session);
    }

    public static UserEntity getCurrentUser(HttpSession session) {
        if (session != null) {
            UserEntity curUser = (UserEntity)session.getAttribute(SESSION_KEY);
            if (curUser != null) {
                return curUser;
            }
        }
        return null;
    }
}
