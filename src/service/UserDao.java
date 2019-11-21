package service;

import org.springframework.stereotype.Service;
import pojo.User;
import java.util.List;
@Service
public interface UserDao {
    public User Login(User user);
    public List<User> selectUser(User user);
}

