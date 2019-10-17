package POJO;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "user", schema = "basedata", catalog = "")
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private Map<Long, String> modelUrl;
    private Map<Long, Long> resourceModule;

    /**
     *   @GeneratedValue(strategy = GenerationType.IDENTITY)//相当于Hibernate框架的identity主键生成策略，适用于MySQL,SQL Server
     * 默认情况下API规范是不支持Hibernate框架中的uuid的主键生成策略，假如我们想要使用，需要我们进行增加主键生成器，如下：
     *
     * @GenericGenerator(name="hibernate-uuid",strategy="uuid")
     *
     * @GeneratedValue(generator="hibernate-uuid")
     * @return
     */
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Transient表示该属性并非一个到数据库表的字段的映射
    @Transient
    public Map<Long, String> getModelUrl() {
        return this.modelUrl;
    }

    public void setModelUrl(Map<Long, String> modelUrl) {
        this.modelUrl = modelUrl;
    }
    @Transient
    public Map<Long, Long> getResourceModule() {
        return this.resourceModule;
    }

    public void setResourceModule(Map<Long, Long> resourceModule) {
        this.resourceModule = resourceModule;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
