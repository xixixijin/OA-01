package ming.jin.oa01.mapper;

import ming.jin.oa01.bean.Department;
import ming.jin.oa01.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
public interface UserMapper {

    @Select("select * from user")
    @Results(id = "id",value = {
            @Result(column = "department_id",property = "department",one = @One(
                    select = "ming.jin.oa01.mapper.DepartmentMapper.selectDepartmentById",fetchType = FetchType.EAGER
            )),
            @Result(column = "role_id",property = "role",one = @One(
                    select = "ming.jin.oa01.mapper.RoleMapper.selectRoleById",fetchType = FetchType.EAGER
            ))
    })
    List<User> getAllUser();

    @Select("select * from user where department_id=#{departmentId}")
    List<User> selectUserByDepartmentId(String departmentId);

    @Select("select * from user where login_name=#{name}")
    User selectUserByName(String name);

    @Insert("insert into user (login_name,user_name,department_id,role_id,password,gender,phone_number,email,description) values(#{loginName},#{userName},#{departmentId},#{roleId},#{password},#{gender},#{phoneNumber},#{email},#{description})")
    void addUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(String id);

    @Select("select * from user where id=#{id}")
    User selectUserById(String id);

    @Update("update user set gender=#{gender},phone_number=#{phoneNumber},email=#{email},description=#{description},role_id=#{roleId} where id=#{id}")
    void updateUser(User user);

    @Update("update user set password=1234 where id = #{id}")
    void initializaPwd(String id);
}
