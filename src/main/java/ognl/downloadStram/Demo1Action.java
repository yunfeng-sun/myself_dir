package ognl.downloadStram;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Demo1Action extends ActionSupport {
    private InputStream is ;
    private String fileName ;

    public String getFileName() {
        try {
            return URLEncoder.encode( "汤姆逊.zip","UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public InputStream getIs() {
        //获得servletcontext
        ServletContext sc =  ServletActionContext.getServletContext();
        //获得文件的流  / 为web root目录
        is = sc.getResourceAsStream("/WEB-INF/apache-maven-3.6.0-bin.zip");
        return is;
    }

    @Override
    public String execute() throws Exception {

        return super.execute();
    }
}
