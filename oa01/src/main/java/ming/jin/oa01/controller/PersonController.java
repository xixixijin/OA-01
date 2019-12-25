package ming.jin.oa01.controller;

import ming.jin.oa01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Haokun
 * @date 2019/12/22 21:52
 * <p>
 * OA-01
 */
@Controller("Person_Config")
public class PersonController {
    @Autowired
    UserService userService;

    @RequestMapping("editUserInfo.html")
    public String editUserInfo(ModelMap map){


        return "Person_Config/editUserInfoUI.html";
    }




}
