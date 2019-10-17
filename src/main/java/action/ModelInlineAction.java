////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//package action;
//
//import com.foton.cloud.basic.core.web.util.ServletUtils;
//import com.foton.m2m.cbm.manage.model.CompanyResource;
//import com.foton.m2m.cbm.manage.service.CompanyResourceService;
//import com.opensymphony.xwork2.ActionSupport;
//import javax.servlet.http.HttpServletRequest;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.struts2.ServletActionContext;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class ModelInlineAction extends ActionSupport {
//    private static final long serialVersionUID = 1L;
//    @Autowired
//    private transient CompanyResourceService companyResourceService;
//    private String url;
//
//    public ModelInlineAction() {
//    }
//
//    public String send() {
//        HttpServletRequest request = ServletActionContext.getRequest();
//        Long id = ServletUtils.getLongValue(request, "id");
//        if (id != null) {
//            CompanyResource resource = (CompanyResource)this.companyResourceService.get(id);
//            this.url = resource.getUrl();
//            if (!StringUtils.isEmpty(this.url)) {
//                String params = request.getQueryString();
//                if (!StringUtils.isEmpty(params)) {
//                    int n = params.indexOf("&");
//                    if (n > -1) {
//                        this.url = this.url + "?" + params.substring(n + 1, params.length());
//                    }
//                }
//
//                Long moduleId = (Long)resource.getModule().getId();
//                if (moduleId != null) {
//                    request.getSession().setAttribute("MODEL_ID", moduleId + "");
//                    request.getSession().setAttribute("COMPANY_RESOURCE_ID", id);
//                }
//            }
//        }
//
//        return "success";
//    }
//
//    public String getUrl() {
//        return this.url;
//    }
//}
