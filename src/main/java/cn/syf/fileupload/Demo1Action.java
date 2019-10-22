package cn.syf.fileupload;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.UUID;

//todo 文件上传由拦截器完成  FileuploadInterceptor 看条件判断 max ； parameterInterceptor 实际处理action的file
public class Demo1Action extends ActionSupport {

    private File file ; // 与 jsp中 <s:file name="file" 的 name 一致
    private String fileContentType ;
    private String fileFileName ; // inputName fileName
    public String execute(){
        System.out.println(file);
        //将文件放入res文件夹下
        String dirPath = ServletActionContext.getServletContext().getRealPath("/res"); //得到 res文件夹 路径
        String fileName = UUID.randomUUID().toString();
        System.out.println(dirPath+fileName);
        File target = new File(dirPath+"   ====   "+fileName); // 创建目标文件
        file.renameTo(target);  //todo 将file 拷贝到 指定的目标文件夹
        System.out.println("上传文件的Mime类型:"+fileContentType);
        System.out.println("上传文件的文件类型:"+fileFileName);
        return SUCCESS;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
}
