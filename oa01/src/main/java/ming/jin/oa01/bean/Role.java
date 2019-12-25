package ming.jin.oa01.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Haokun
 * @date 2019/12/19 23:41
 * <p>
 * OA-01
 */
public class Role implements Serializable {
    private String id;
    private String roleName;
    private String description;
    private List<User> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
