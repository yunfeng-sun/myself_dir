package POJO;

import java.util.HashSet;
import java.util.Set;

public class Coursess {
    private Integer cid ;
    private String content ;
    private String teacher ;
    //多对多  不同课程(当前课程)，被【不同学生】学习
    private Set<Studentsss> studentssses = new HashSet<Studentsss>();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Set<Studentsss> getStudentssses() {
        return studentssses;
    }

    public void setStudentssses(Set<Studentsss> studentssses) {
        this.studentssses = studentssses;
    }
}
