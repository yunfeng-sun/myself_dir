package service.Impl;

import POJO.UserEntity;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;


import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    //自动注入userDao @Resource 也可以使用@Autowired
    @Autowired
    private UserDao userDao ;

    public boolean addUser(UserEntity user) {
        this.userDao.add(user);
        return true;
    }

    public boolean login(UserEntity user) {
        return this.userDao.login(user);
    }

    public List getAllUser() {
        return this.userDao.getUser();
    }

    public UserEntity getUserById(int id) {
        return this.userDao.getUser(id);
    }

    public boolean updateUser(UserEntity user) {
        this.userDao.update(user);
        return true ;
    }

    public boolean deleteUser(int id) {
        this.userDao.delete(id);
        return true;
    }
}
