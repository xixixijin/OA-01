package ming.jin.oa01.mapper;

import ming.jin.oa01.bean.Department;
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
public interface DepartmentMapper {

    @Select("select * from department")
    @Results(id = "id",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column ="department_name",property = "departmentName"),
            @Result(column = "department_id",property = "users",many = @Many(
                    select = "ming.jin.oa01.mapper.UserMapper.selectUserByDepartmentId"
            ))

    })
    List<Department> selectAllDepartment();

    @Select("select * from department where id=#{id}")
    @Results(value = {
            @Result(column = "department_id",property = "users",many = @Many(
                    select = "ming.jin.oa01.mapper.UserMapper.selectUserByDepartmentId"
            ))
    })
    Department selectDepartmentById(String id);
    //查询一级列表
    @Select("select * from department where parent_department_id = 0")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id",property = "childrens",many = @Many(
                    select = "ming.jin.oa01.mapper.DepartmentMapper.selectLevel2List"
            ))
    })
    List<Department> selectLevel1List();
    //查询二级列表
    @Select("select * from department where parent_department_id=#{id}")
    @Results(value = {
            @Result(column = "parent_department_id",property = "parent",one = @One(
                    select = "ming.jin.oa01.mapper.DepartmentMapper.selectDepartmentById"
            ))
    })
    List<Department> selectLevel2List(String id);

    @Delete("delete from department where id=#{id} or parent_department_id=#{id}")
    void delete(String id);

    @Insert("insert into department (department_name,description, parent_department_id) values(#{departmentName},#{description},#{parentId})")
    void insertDepartment(Department department);

    @Update("update department set department_name=#{departmentName},description=#{description},parent_department_id=#{parentId} where id =#{id} ")
    void updateDepartment(Department department);
}
