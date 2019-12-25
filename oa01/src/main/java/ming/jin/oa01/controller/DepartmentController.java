package ming.jin.oa01.controller;

import ming.jin.oa01.bean.Department;
import ming.jin.oa01.service.DepartmentService;
import ming.jin.oa01.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/21 19:49
 * <p>
 * OA-01
 */
@Controller
@RequestMapping("SystemDepartment")
public class DepartmentController {




    @Autowired
    DepartmentServiceImpl departmentService;

    //一级列表
    @RequestMapping("list.html")
    public String deList(ModelMap map) {
        List<Department> departments = departmentService.selectLevel1List();
        map.put("departments", departments);
        return "System_Department/list.html";
    }

    //二级列表
    @RequestMapping("_list_level2.html/{id}")
    public String deList2(@PathVariable String id, ModelMap map) {
        List<Department> departments = departmentService.selectLevel2List(id);
        map.put("departments", departments);

        return "System_Department/_list_level2.html";
    }

    //新建页面
    @RequestMapping("saveUI.html")
    public String addDepartment(ModelMap map) {
        firstList(map);
        return "System_Department/saveUI.html";
    }
//删除部门
    @RequestMapping("delete")
    public String delete(String id){
        departmentService.delete(id);
        return "forward:list.html";
    }
//新增部门
    @RequestMapping("saveDepartment")
    public String save(Department department){
        if (!department.getId().equals("")){
            departmentService.updateDepartement(department);
        }else {
            departmentService.addDepartment(department);
        }
        return "forward:list.html";
    }
    //修改部门
    @RequestMapping("editDepartment")
    public String editDepartment(Department department){

        return "System_Department/saveUI.html";
    }

    void firstList(ModelMap map) {
        List<Department> departments = departmentService.selectLevel1List();
        map.put("departments", departments);
    }


}
