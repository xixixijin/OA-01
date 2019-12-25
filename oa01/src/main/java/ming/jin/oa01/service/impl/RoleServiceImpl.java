package ming.jin.oa01.service.impl;

import ming.jin.oa01.bean.Role;
import ming.jin.oa01.mapper.RoleMapper;
import ming.jin.oa01.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/20 0:19
 * <p>
 * OA-01
 */
@Service("roleservice")

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> getRole() {
        return roleMapper.selectRole();
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public Role selectRoleById(String id) {
        return roleMapper.selectRoleById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public void deleteRole(String roleId) {
        roleMapper.deleteRole(roleId);
    }
}
