package ming.jin.oa01.bean;



import java.io.Serializable;
import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/19 23:45
 * <p>
 * OA-01
 */
public class Department implements Serializable {
    private String id;
    private String departmentName;
    private String description;
    private String parentId;
    private List<User> users;
    private Department parent;
    private List<Department> childrens;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public List<Department> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Department> childrens) {
        this.childrens = childrens;
    }
}
