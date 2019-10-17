//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package action;

import POJO.UserEntity;
import com.opensymphony.xwork2.ActionSupport;

import java.lang.reflect.Array;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import config.ConfigMapService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import utils.ContextUtil;
import utils.ServletUtils;

@Controller("model")
@Scope("prototype")
public class ModelAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
//    @Autowired(required = false)
//    private transient ConfigMapService configService;
    private String url;

    public ModelAction() {
    }

    public String send() {
        HttpServletRequest request = ServletActionContext.getRequest();
//        Object params = request.getAttribute("param");
//        String[] ps = (String[]) params;
//        System.out.println(Array.get(ps,1));
//        Long id = ServletUtils.getLongValue(request, "id", (Long)null);
//        System.out.println(id+"============================");
//        if (id != null) {
//            UserEntity user = ContextUtil.getCurrentUser();
//            if (user != null) {
//                Map<Long, String> modelUrl = user.getModelUrl();
//                this.url = modelUrl != null ? (String)modelUrl.get(id) : null;
//                if (!StringUtils.isEmpty(this.url)) {
//                    this.url = this.url.replace("${mapType}", this.getMapType(request));
//        String username = ServletUtils.getStringValue(request, "user.username", null);
//        String password = ServletUtils.getStringValue(request, "user.password", null);
//        user.setUsername(username);   报错
//        user.setPassword(password);
//                    String params = request.getQueryString();
//                    if (!StringUtils.isEmpty(params)) {
//                        int n = params.indexOf("&");
//                        if (n > -1) {
//                            this.url = this.url + "?" + params.substring(n + 1, params.length());
//                            this.url = "/user_action!login.do"  + "?" + "user.username" + "=" + username + "&" + "user.password" + "=" + password;
                            this.url = "user_login";
//                        }
//                    }

//                    Long moduleId = (Long)user.getResourceModule().get(id);
//                    if (moduleId != null) {
//                        HttpSession session = request.getSession();
//                        session.setAttribute("MODEL_ID", String.valueOf(moduleId));
//                        session.setAttribute("RESOURCE_ID", String.valueOf(id));
//                    }
//                }
//            }
//        }
//        this.url = "/common/success.jsp" ;
        if (StringUtils.isEmpty(this.url)) {
            this.url = "/403.html";
            return "success";
        } else {
            return "success";
        }
    }

    // 有个 config 配置表 根据表获取对应的 类型得路径
    private String getMapType(HttpServletRequest request) {
        String mapType = (String)request.getAttribute("mapType");
        if (StringUtils.isEmpty(mapType)) {
//            mapType = this.configService.getValue("mapType", "baidu");
        }
        return "map/" + mapType;
    }

    public String getUrl() {
        return this.url;
    }
}
