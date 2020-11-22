package cn.bupt.edu.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class hellocontroller {
    @RequestMapping("/login")
    public String login(@RequestParam (value = "user",required = false)String user, @RequestParam (value = "psw",required = false)String psw, HttpSession session)
    {
        if (user!=null && psw!=null && user.equals(("123@bupt.edu.cn")) && psw.equals("123456"))
        {
            session.setAttribute("log",true);
            return "contact";
        }
        return "login";
    }

}
