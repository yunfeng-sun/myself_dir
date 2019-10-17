package service;

import POJO.UserEntity;

import java.util.List;

public interface UserService {
    public boolean addUser(UserEntity user);

    public boolean login(UserEntity user);

    public List getAllUser();

    public UserEntity getUserById(int id);

    public boolean updateUser(UserEntity user);

    public boolean deleteUser(int id);
}
