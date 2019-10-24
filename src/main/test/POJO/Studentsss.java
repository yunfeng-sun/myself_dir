package POJO;

import java.util.HashSet;
import java.util.Set;

public class Studentsss {
    private Integer sId ;
    private String name ;
    // 多对多 多个学生学习 不同课程
    private Set<Coursess> coursesses = new HashSet<Coursess>();

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Coursess> getCoursesses() {
        return coursesses;
    }

    public void setCoursesses(Set<Coursess> coursesses) {
        this.coursesses = coursesses;
    }
}
