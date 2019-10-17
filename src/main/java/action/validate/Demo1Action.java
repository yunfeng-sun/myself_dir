package action.validate;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("Demo1Action")
@Scope("prototype")
public class Demo1Action extends ActionSupport  {

    private String name ;

    /**
     * 若访问add方法，则走表单验证
     * @return
     */
    public String add(){

        return SUCCESS;
    }
    /**
     * 若访问find方法，则不走表单验证
     * @return
     */
    @SkipValidation
    public String find(){

        return "find";
    }

    /**
     * 优势：多个方法可以指定多个校验方式
     * 指定方法验证格式： validate+将验证的方法名
     * validate拦截器父类 ValidationInterceptor  含有判断 方法前缀 validate / validateDo
     */
    public void validateAdd() {
        addFieldError("name","我说的，用户名不对！");
    }
//    @Override
//    public void validate() {
//        if(name == null || name.trim().equals("") || name.length() == 0){
//            addFieldError("name","用户名不合法！");
//        }
//        super.validate();
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
