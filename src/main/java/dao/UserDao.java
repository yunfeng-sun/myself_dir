package dao;

import POJO.UserEntity;

import java.util.List;

public interface UserDao {
    void add(UserEntity user);
    boolean login(UserEntity user);
    List getUser();
    UserEntity getUser(int id);
    void update(UserEntity user);
    void delete(int id);
}
