package ming.jin.oa01.controller;

import ming.jin.oa01.bean.Department;
import ming.jin.oa01.bean.Role;
import ming.jin.oa01.bean.User;
import ming.jin.oa01.service.DepartmentService;
import ming.jin.oa01.service.RoleService;
import ming.jin.oa01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Haokun
 * @date 2019/12/21 18:45
 * <p>
 * OA-01
 */
@Controller
@RequestMapping("SystemUser")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;
    /**
     * 用户列表页面
     *
     * @param map
     * @return
     */
    @RequestMapping("list.html")
    public String userList(ModelMap map) {
        List<User> users = userService.getAllUser();
        map.put("users", users);
        return "System_User/list.html";
    }

    /**
     * 保存页面
     *
     * @return
     */
    @RequestMapping("saveUI.html")
    public String addUser(ModelMap map) {
        List<Department> departments = departmentService.selectLevel1List();
        List<Role> roles= roleService.getRole();
        map.put("departments", departments);
        map.put("roles",roles);
        return "System_User/saveUI.html";
    }

    @RequestMapping("logout.html")
    public String logout() {
        return "System_User/logout.html";
    }

    @RequestMapping("loginUI.html")
    public String login() {
        return "System_User/loginUI.html";
    }
    @RequestMapping("login")
    public String loginu(String loginName,String password,Map<String,Object> map, HttpSession session){
        if(loginName!=null&&password!=null){
            User user = userService.gerUserByName(loginName);
            if (user!=null&&user.getPassword().equals(password)){
                session.setAttribute("loginUser",loginName);
                session.setAttribute("user",user);
                return "redirect:/index.html";
            }
        }



        return "System_User/loginUI.html";
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping("saveUser")
    public String saveUser(User user){
        if (user.getId()!=null){
            userService.editUser(user);
        }else {
            user.setPassword("1234");
            userService.addUser(user);
        }
        return "forward:list.html";
    }
    //删除用户
    @RequestMapping("deleteUser")
    public String deleteUser(String id){
        userService.deleteUser(id);
        return "forward:list.html";
    }
    //修改用户
    @RequestMapping("editUser")
    public String editUser(ModelMap map,String id){
        List<Department> departments = departmentService.selectLevel1List();
        List<Role> roles= roleService.getRole();
        User user=userService.getUserById(id);
        map.put("user",user);
        map.put("departments", departments);
        map.put("roles",roles);
        return "System_User/saveUI.html";
    }
    //初始化密码
    @RequestMapping("initializePwd")
    public String initializePwd(String id){
        userService.initializePwd(id);
        return "forward:list.html";
    }
}
