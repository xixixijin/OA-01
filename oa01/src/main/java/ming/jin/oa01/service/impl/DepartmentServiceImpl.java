package ming.jin.oa01.service.impl;

import ming.jin.oa01.bean.Department;
import ming.jin.oa01.mapper.DepartmentMapper;
import ming.jin.oa01.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/21 19:17
 * <p>
 * OA-01
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Department selectDepartmentById(String id) {
        return departmentMapper.selectDepartmentById(id);
    }

    /**
     * 查询一级列表
     * @return
     */
    @Override
    public List<Department> selectLevel1List() {
        return departmentMapper.selectLevel1List();
    }

    /**
     * 查询二级列表
     * @param id
     * @return
     */
    @Override
    public List<Department> selectLevel2List(String id) {
        return departmentMapper.selectLevel2List(id);
    }

    @Override
    public void delete(String id) {
        departmentMapper.delete(id);
    }

    @Override
    public void addDepartment(Department department) {
        departmentMapper.insertDepartment(department);
    }

    @Override
    public void updateDepartement(Department department) {
        departmentMapper.updateDepartment(department);
    }
}

