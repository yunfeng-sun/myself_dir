package POJO;

import javax.persistence.*;

@Entity
@Table(name = "test1", schema = "basedata", catalog = "")
public class Test1Entity {
    private int qwe;
    private String ret;

    @Id
    @Column(name = "qwe")
    public int getQwe() {
        return qwe;
    }

    public void setQwe(int qwe) {
        this.qwe = qwe;
    }

    @Basic
    @Column(name = "ret")
    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test1Entity that = (Test1Entity) o;

        if (qwe != that.qwe) return false;
        if (ret != null ? !ret.equals(that.ret) : that.ret != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = qwe;
        result = 31 * result + (ret != null ? ret.hashCode() : 0);
        return result;
    }
}
