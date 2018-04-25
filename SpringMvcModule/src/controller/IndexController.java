package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController{
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("msg","Hello World");
        return mav;
    }

    @RequestMapping("/jump")
    public ModelAndView jump(){
        ModelAndView mav = new ModelAndView("redirect:/index");
        return mav;
    }

    @RequestMapping("/count")
    public ModelAndView check(HttpSession session){
        Integer i = (Integer) session.getAttribute("count");
        if (i == null)
            i = 0;
        i++;
        session.setAttribute("count", i);
        ModelAndView mav = new ModelAndView("count");
        return mav;
    }

//    @Override
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("msg","Hello,Spring MVC");
//        return mav;
//    }
}
