package controller;

import bean.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/product")
public class ProductController {
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("addProduct");
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(Product product){
        ModelAndView mav = new ModelAndView("showProduct");
        mav.addObject("product", product);
        return mav;
    }

}
