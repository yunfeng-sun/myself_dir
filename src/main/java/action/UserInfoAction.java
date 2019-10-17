package action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller("userInfo")
@Scope("prototype")
public class UserInfoAction extends ActionSupport {
    private String name ;
    private int age ;
    private int sex ; // 1 男 0 女
    private Date birthday ;
    private String result ;

    public String register(){
        System.out.println(birthday + "action =======>>>");
        if(true){
            result = "登记成功！" ;
        }
        return SUCCESS;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
