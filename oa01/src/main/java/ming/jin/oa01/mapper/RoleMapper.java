package ming.jin.oa01.mapper;

import ming.jin.oa01.bean.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/20 0:07
 * <p>
 * OA-01
 */
@Mapper
@Component
public interface RoleMapper {

    @Select("select * from role ")
    List<Role> selectRole();

    @Select("select * from role where id=#{id}")
    Role selectRoleById(String id);

    @Insert("insert into role set role_name=#{roleName},description=#{description}")
    void addRole(Role role);

    @Update("update role set role_name=#{roleName},description=#{description} where id=#{id}")
    void updateRole(Role role);

    @Delete("delete from role where id=#{id}")
    void deleteRole(String id);

}
