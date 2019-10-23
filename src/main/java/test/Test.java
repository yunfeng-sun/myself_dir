package test;

import POJO.Test1Entity;
import POJO.UserEntity;
import org.hibernate.Query;
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
//        conf.addClass(UserEntity.class); //加载 UserEntity 同级目录下的  hbm.xml 文件 (获取类对象路径 将点. replace 为 / + .hbm.xml) 映射名称的规范
//        conf.addResource(""); // 加载指定的 映射文件 hbm.xml ；
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null ;
        try {
             transaction = session.beginTransaction();

            //创建服务注册对象
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            //todo 创建会话工厂对象，线程安全        相当于连接池
//        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            //todo 会话对象  相当于jdbc连接
//        Session session = sessionFactory.openSession();
            //开启事务
//        Transaction transaction = session.beginTransaction();

            UserEntity entity = new UserEntity();
            entity.setId(3);
            entity.setUsername("user" + 3);
            entity.setPassword("qwer" + 3);
            session.save(entity);

//todo 操作
//        session.save(entity);  // 添加   或者 persist()
//        session.update(entity); // 更新  saveOrUpdate()
//        session.delete(entity); // 删除
//        session.get(UserEntity.class,3);  //查询指定id 到 对象中  或者 load() 根据主键查询
//        Query query = session.createQuery("from UserEntity"); //或者 createSQLQuery()   查询所有 from后必须为对象  或者写为 POJO.UserEntity
            // createOrIteria() 条件查询  QBC hibernate的纯面向对象语句
//      query.setFirstResult(0); //设置分页查询  这里只有第一页 从 0 - 2
//      query.setMaxResults(2);
//        List<UserEntity> list = query.list();
            //提交事务
            transaction.commit();
        }catch (Exception e){
            if(transaction == null){
//                commit transcation :标志一个成功的隐性事务或显性事务的结束，提交事务并永久保存在数据库中。
//                rollback transcation:在事务中出错或用户决定取消事务，数据回滚到最初始状态。
                transaction.rollback();
            }
        }
        //todo 关闭会话 必须关闭
        finally {
            session.close();
            //关闭会话工厂  可以不关 工厂就一个
            sessionFactory.close();

            System.out.println("Successful saved! ");
        }
    }
}
