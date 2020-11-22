package cn.bupt.edu.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class contact {
    @RequestMapping("/toadd")
    public String toadd()
    {
        return "add_contact";
    }

    @RequestMapping("/toedit")
    public String toedit()
    {
        return "edit";
    }


}
