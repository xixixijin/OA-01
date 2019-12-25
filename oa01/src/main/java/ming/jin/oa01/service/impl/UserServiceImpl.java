package ming.jin.oa01.service.impl;

import ming.jin.oa01.bean.User;
import ming.jin.oa01.mapper.UserMapper;
import ming.jin.oa01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/21 18:57
 * <p>
 * OA-01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User gerUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userMapper.deleteUser(id);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void editUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void initializePwd(String id) {
        userMapper.initializaPwd(id);
    }
}
