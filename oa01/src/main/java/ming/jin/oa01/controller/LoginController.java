package ming.jin.oa01.controller;

import ming.jin.oa01.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Haokun
 * @date 2019/12/19 19:32
 * <p>
 * OA-01
 */
@Controller
public class LoginController {

    @RequestMapping({"index.html"})
    public String index(){
        return "index";
}


    @RequestMapping("top.html")
    public String top(HttpSession session, ModelMap map){
        User user=(User)session.getAttribute("user");
        map.put("user",user);
        return "top";
    }
    @RequestMapping("left.html")
    public String left(){
        return "left";
    }
    @RequestMapping("right.html")
    public String right(){
        return "right";
    }
    @RequestMapping("bottom.html")
    public String bottom(){
        return "bottom";
    }

}
