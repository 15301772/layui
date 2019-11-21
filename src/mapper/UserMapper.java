package mapper;

import pojo.User;

import java.util.List;

public interface UserMapper {
    public User Login(User user);
    public List<User> selectUser(User user);
    public User selectById(Integer id);
    public List<User> selectByName(User user);
    public void insertUser(User user);
    public void deleteUser(Integer id);
    public void updateUser(User user);
    public void pwdUpdate(User user);
    public int CheckUserName(String username);
    public List<User> searchByWhere(User user);
}
