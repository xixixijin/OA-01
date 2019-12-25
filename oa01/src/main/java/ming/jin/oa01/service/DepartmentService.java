package ming.jin.oa01.service;

import ming.jin.oa01.bean.Department;

import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/21 19:17
 * <p>
 * OA-01
 */
public interface DepartmentService {

    Department selectDepartmentById(String id);
    List<Department> selectLevel1List();
    List<Department> selectLevel2List(String id);

    void delete(String id);

    void addDepartment(Department department);

    void updateDepartement(Department department);
}
