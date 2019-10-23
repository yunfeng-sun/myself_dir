package syf.main;

import POJO.Person;
import POJO.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class TestApp {
    @Test
    public void demo01() throws IOException {
        FileInputStream is = new FileInputStream(new File("D:/11.bmp"));
        byte[] photo = new byte[is.available()];
        is.read(photo);
        is.close();

        Person person = new Person();
        person.setName("杰克");
        person.setAge(18);
        person.setBirthday(new Date());
        System.out.println(new Date());
        person.setGender(true);
        person.setPhoto(photo);
        person.setDesc("这是个图像！");
        Configuration conf = new Configuration();
        conf.configure();
        //采用手动添加 hbm.xml文件
        conf.addClass(Person.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);
        transaction.commit();
        session.close();
    }

    @Test
    public void demo02(){
        SessionFactory factory = new Configuration().configure().addClass(Student.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setName("张三");
        session.save(student);

        transaction.commit();
        session.close();
    }

    @Test
    public void demo3(){
        SessionFactory factory = new Configuration().configure().addClass(Student.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        //证明session有一级缓存  看是否只有一条sql语句  只有一条
        Student stu1 = (Student)session.get(Student.class,1);
        System.out.println(stu1);
        Student stu2 = (Student)session.get(Student.class,1);
        System.out.println(stu2);

        transaction.commit();
        session.close();
    }
}
