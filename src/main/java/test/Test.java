package test;

import POJO.Test1Entity;
import POJO.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static List<UserEntity> userlist = Collections.synchronizedList(new ArrayList<UserEntity>());
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //创建服务注册对象
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
//        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //会话对象
//        Session session = sessionFactory.openSession();
        //开启事务
//        Transaction transaction = session.beginTransaction();

//        Test1Entity entity = new Test1Entity();
//        entity.setQwe(3);
//        entity.setRet("hello3");

        UserEntity entity = new UserEntity();

//        for (int i=0;i< userlist.size();i++) {
//            Transaction tran = session.beginTransaction();
//        for(int i=1;i<4;i++) {
            entity.setId(3);
            entity.setUsername("user"+3);
            entity.setPassword("qwer"+3);
//            userlist.add(entity);
            session.save(entity);
//        }
//            session.save(userlist);
//            tran.commit();
//        if (test.count++ % 10 == 0) {
//            System.out.println(test.count);
//            session.flush();
//            session.clear();
//        }
//        }
//        session.save(entity);
//        session.update(entity);
//        session.delete(entity);
        //提交事务
        transaction.commit();
        //关闭会话
        session.close();
        //关闭会话工厂
        sessionFactory.close();

        System.out.println("Successful saved! ");
    }
}
