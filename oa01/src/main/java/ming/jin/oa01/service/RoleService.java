package ming.jin.oa01.service;

import ming.jin.oa01.bean.Role;

import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/20 0:18
 * <p>
 * OA-01
 */
public interface RoleService {
    List<Role> getRole();
    void addRole(Role role);
    void updateRole(Role role);
    Role selectRoleById(String id);
    void deleteRole(String roleId);

}
