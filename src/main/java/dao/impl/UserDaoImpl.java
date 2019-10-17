package dao.impl;

import POJO.UserEntity;
import dao.UserDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

//出现Exception异常进行回滚
@Transactional(rollbackFor = Exception.class)
@Repository("userDao") //进行注入
public class UserDaoImpl implements UserDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory ;

    public void add(UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional(readOnly = true)
    public boolean login(UserEntity user) {
        Iterator<UserEntity> it ;
        String hsql = "FROM UserEntity u where u.username=? and u.password=?";
//        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getUsername());
        query.setString(1, user.getPassword());
        System.out.println(user.getUsername());
        it=query.iterate();
        if(it.hasNext()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
    @Transactional(readOnly = true)
    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM UserEntity").list();
    }

    public UserEntity getUser(int id) {
        return (UserEntity)sessionFactory.getCurrentSession().get(UserEntity.class,id);
    }

    public void update(UserEntity user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(UserEntity.class,id));
    }
}
