package ming.jin.oa01.service;

import ming.jin.oa01.bean.User;

import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/21 18:57
 * <p>
 * OA-01
 */
public interface UserService {
    List<User> getAllUser();
    User gerUserByName(String name);
    void addUser(User user);

    void deleteUser(String id);

    User getUserById(String id);

    void editUser(User user);

    void initializePwd(String id);
}
