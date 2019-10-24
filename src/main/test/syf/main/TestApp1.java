package syf.main;

import POJO.Coursess;
import POJO.Studentsss;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class TestApp1 {
    private  SessionFactory factory = new Configuration().configure()
            .addClass(Studentsss.class)
            .addClass(Coursess.class)
            .buildSessionFactory();

    /**name 属性名称  class 属性对应类型  column 外键名称
     * 一对多  容器(Array/List/Map/Set )           set 不重复 无序  一对多建议从多方开始;
     * 一方
     * *<set name="orderSet" >
     *       <key column="consume_id"/>  主键
     *       <one-to-many class="POJO.Order"/> 对谁为one
     * </set>
     * 多方
        <many-to-one class="POJO.Consume" column="consume_id"/> 外键
     */
    @Test
    public void demo1(){
        // 先 创建表 create
        Session session = factory.openSession();
        session.close();
    }
    @Test
    public void demo2(){
        // Studentsss 赋值
        Session session = factory.openSession();
        session.beginTransaction();

        Studentsss studentsss = new Studentsss();
        studentsss.setName("jack");

        session.save(studentsss);

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void demo3(){
        // Coursess 赋值
        Session session = factory.openSession();
        session.beginTransaction();

        Coursess coursess = new Coursess();
        coursess.setContent("javaWeb");
        coursess.setTeacher("东东");

        session.save(coursess);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void demo4(){
        /*学生关联课程---只保存学生 org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: POJO.Coursess
        *瞬时对象异常  一个持久态 引用了 瞬时态对象 ； (学生关联课程，但课程是瞬时态的，没有OID)
        * 方案：
        *   1 转为 持久
        *   2 级联保存 保存学生时同时将其关联的课程一并保存，则需要给学生配置  Studentsss.hbm.xml
        *<set name="coursesses" table="s_student_course" cascade="save-update">
        */
        Session session = factory.openSession();
        session.beginTransaction();

        Studentsss studentsss = new Studentsss();
        studentsss.setName("rose");

        Coursess coursess = new Coursess();
        coursess.setContent("java基础");
        coursess.setTeacher("西西");
        //学生关联（引用）课程 =  ============   todo 多对多 使用数据关联，维护的是中间表的外键信息（一个表，执行insert delete）  ；  一对多 使用数据关联，维护的是从表的外键（一个字段，执行update）
        studentsss.getCoursesses().add(coursess);
        //保存学生
        session.save(studentsss);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void demo5(){
        /*双向关联  两个对象都对中间表的数据进行维护，将存在重复的执行insert语句，抛异常
        则 todo 多对多 其中一方必须放弃对中间表的维护权
         <set name="coursesses" table="s_student_course"  inverse="true">
         将减少放弃维护的一条 insert 中间表 语句
         */
        Session session = factory.openSession();
        session.beginTransaction();

        Studentsss studentsss = new Studentsss();
        studentsss.setName("rose");

        Coursess coursess = new Coursess();
        coursess.setContent("java基础1");
        coursess.setTeacher("西西1");
        //学生关联（引用）课程
        studentsss.getCoursesses().add(coursess); //insert into s_student_course(student_id, course_id)   中间表为联合主键，交换位置的组合不可重复 2 3 / 3 2 为重复  1 2 / 1 3 可以
        //课程关联（引用） 学生
        coursess.getStudentssses().add(studentsss);//insert into s_student_course(course_id, student_id)

        //保存
        session.save(studentsss);
        session.save(coursess);

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void demo6(){
        /* 初始化 多个 数据
         */
        Session session = factory.openSession();
        session.beginTransaction();

        Studentsss studentsss1 = new Studentsss();
        studentsss1.setName("jack");
        Studentsss studentsss2 = new Studentsss();
        studentsss2.setName("rose");
        Studentsss studentsss3 = new Studentsss();
        studentsss3.setName("tom");

        Coursess coursess1 = new Coursess();
        coursess1.setContent("java基础");
        coursess1.setTeacher("西西");
        Coursess coursess2 = new Coursess();
        coursess2.setContent("javaWeb");
        coursess2.setTeacher("东东");
        Coursess coursess3 = new Coursess();
        coursess3.setContent("java ssh");
        coursess3.setTeacher("北北");

        //学生关联（引用）课程
        studentsss1.getCoursesses().add(coursess1); //insert into s_student_course(student_id, course_id)   中间表为联合主键，交换位置的组合不可重复 2 3 / 3 2 为重复  1 2 / 1 3 可以
        studentsss1.getCoursesses().add(coursess2);
        studentsss1.getCoursesses().add(coursess3);

        studentsss2.getCoursesses().add(coursess2);
        studentsss2.getCoursesses().add(coursess3);

        studentsss3.getCoursesses().add(coursess3);
        //保存
        session.save(coursess1);
        session.save(coursess2);
        session.save(coursess3);
        session.save(studentsss1);
        session.save(studentsss2);
        session.save(studentsss3);

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void demo7(){
        // 删除student的 id=1 的数据 会 删除 中间表数据 和 删除 学生数据 ； 此时 学生表维护中间表数据  单独删除某学生课程
        /**双方配置 级联删除 两个hbm.xml 增加  cascade="delete"
        *       结果：正常运行，清空所有表的数据
         *       why？先维护后级联删除，又维护再级联，再维护
         *inverse 放弃维护
         *  在coursess.hnm.xml 配置 inverse = true ； 结果同上； 流程：少了一步维护，级联仍存在(通过中间表对另一个主表进行级联)
         * 在上述中再配置 将cascade="delete"去除  运行  报错 ； 数据无法对应，报错。
         *
         */
        Session session = factory.openSession();
        session.beginTransaction();

        //查询id=1 的学生
        Studentsss studentsss = (Studentsss)session.get(Studentsss.class,1);
        //删除学生
        session.delete(studentsss); // 删除是 维护中间表操作； 然后才是级联操作，同步更改的

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void demo8(){
        // 删除student的 id=1  对应的 中间表数据 ； 但 学生表数据仍存在
        Session session = factory.openSession();
        session.beginTransaction();

        //查询id=1 的学生
        Studentsss studentsss = (Studentsss)session.get(Studentsss.class,1);
       //清空该学生的课程
        studentsss.getCoursesses().clear();

        session.getTransaction().commit();
        session.close();
    }
}