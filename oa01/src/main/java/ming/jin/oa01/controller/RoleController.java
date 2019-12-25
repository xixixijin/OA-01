package ming.jin.oa01.controller;

import ming.jin.oa01.bean.Role;
import ming.jin.oa01.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/19 19:49
 * <p>
 * OA-01
 */
@Controller
@RequestMapping("SystemRole")
public class RoleController {

    @Autowired
    RoleService roleService;
    @RequestMapping("list.html")
    public String roleList(ModelMap map){
        List<Role> roles=roleService.getRole();
        map.put("roles",roles);
        return "System_Role/list.html";
    }

    @RequestMapping("saveUI.html")
    public String roleSaveUI(){
        return "System_Role/saveUI.html";
    }

    @PostMapping("saveRole")
    public String saveRole( Role role, ModelMap map){
        roleService.addRole(role);
        return roleList(map);
//        List<Role> roles=roleService.getRole();
//        map.put("roles",roles);
//        return "System_Role/list.html";
    }
    @RequestMapping("editRole")
    public String editRole( Role role,ModelMap map){
        map.put("role",role);
        return "System_Role/saveUI.html";
    }
    @RequestMapping("updateRole")
    public String updateRole( Role role){
        roleService.updateRole(role);
        return "forward:list.html";
    }
    @RequestMapping("setPrivilegeUI.html")
    public String setPrivilege(){
        return "System_Role/setPrivilegeUI.html";
    }
    @GetMapping("deleteRole")
    public String deleteRole(String id){
        roleService.deleteRole(id);
        return "forward:list.html";
    }
}
