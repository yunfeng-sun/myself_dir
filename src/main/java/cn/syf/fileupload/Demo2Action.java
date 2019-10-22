package cn.syf.fileupload;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.Arrays;
import java.util.UUID;

// 多文件上传 指定目录 则遍历 file 来一个个指定
public class Demo2Action extends ActionSupport {

    private File[] file ; // 与 jsp中 <s:file name="file" 的 name 一致
    private String[] fileContentType ;
    private String[] fileFileName ; // inputName fileName
    public String execute(){
        System.out.println("上传文件:"+ Arrays.toString(file));
        System.out.println("上传文件的Mime类型:"+ Arrays.toString(fileContentType));
        System.out.println("上传文件的文件类型:"+ Arrays.toString(fileFileName));
        return SUCCESS;
    }

    public File[] getFile() {
        return file;
    }

    public void setFile(File[] file) {
        this.file = file;
    }

    public String[] getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String[] fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String[] getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String[] fileFileName) {
        this.fileFileName = fileFileName;
    }
}
