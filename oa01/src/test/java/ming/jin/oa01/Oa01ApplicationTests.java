package ming.jin.oa01;

import ming.jin.oa01.bean.Role;
import ming.jin.oa01.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Oa01ApplicationTests {

    @Autowired
    RoleMapper mapper;
    @Test
    void contextLoads() {
        List<Role> roles=mapper.selectRole();
        System.out.println();
    }

}
