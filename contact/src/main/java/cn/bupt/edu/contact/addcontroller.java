package cn.bupt.edu.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class addcontroller {
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView add(HttpServletRequest request, HttpSession session){
        ArrayList<info> cList = new ArrayList<info>();
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String add = request.getParameter("add");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        info person = new info();
        person.address=add;
        person.email=email;
        person.name=name;
        person.qq=qq;
        person.tel=tel;
        if(session.getAttribute("cList")!=null)
        {
            cList = (ArrayList<info>)session.getAttribute("cList");
        }
        cList.add(person);
        session.setAttribute("cList", cList);
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("cList",cList);
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView edit(HttpServletRequest request, HttpSession session) {
        ArrayList<info> cList = new ArrayList<info>();
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String add = request.getParameter("add");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        info person = new info();
        person.address=add;
        person.email=email;
        person.name=name;
        person.qq=qq;
        person.tel=tel;
        cList = (ArrayList<info>)session.getAttribute("cList");
        for(info e:cList)
        {
            if (e.name.equals(name))
            {
                e.tel = tel;
                e.qq = qq;
                e.email = email;
                e.address = add;
            }
            break;
        }
        session.setAttribute("cList", cList);
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("cList",cList);
        return modelAndView;
    }

    @RequestMapping("/todel")
    public ModelAndView del(HttpServletRequest request, HttpSession session) {
        ArrayList<info> cList = new ArrayList<info>();
        String id = request.getParameter("id");
        cList = (ArrayList<info>) session.getAttribute("cList");
        cList.remove(Integer.parseInt(id));
        session.setAttribute("cList", cList);
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("cList",cList);
        return modelAndView;

    }

}
