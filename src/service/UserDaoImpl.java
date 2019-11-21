package service;

import mapper.UserMapper;
import pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper mapper;
    @Override
    public User Login(User user){
        return mapper.Login(user);
    }

    @Override
    public List<User> selectUser(User user) { return mapper.selectUser(user); }


}



