package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import entity.Category;
import entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.CategoryService;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

//    @RequestMapping("/list")
//    public ModelAndView list(Page page){
//        ModelAndView mav = new ModelAndView("listCategory");
//        //使用pagehelper
//        PageHelper.offsetPage(page.getStart(),5);
//        List<Category> categories = categoryService.list();
//        int total = (int) new PageInfo<>(categories).getTotal();
//
//        //使用自定义的page对象
////        List<Category> categories = categoryService.list(page);
////        int total = categoryService.total();
////        page.caculateLast(total);
//
//
//        mav.addObject("categories", categories);
//        return mav;
//    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(@RequestBody Category category){
        System.out.println(category);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/query")
    public String queryOneCategory(){
        Category c = new Category();
        c.setId(100);
        c.setName("数码电子");
        Gson gson = new Gson();
        return gson.toJson(c);
    }

    //RESTFUL
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView list(Page page){
        ModelAndView mav = new ModelAndView("listCategory");
        PageHelper.offsetPage(page.getStart(),5);
        List<Category> categories = categoryService.list();
        int total = (int) new PageInfo<>(categories).getTotal();
        mav.addObject("categories", categories);
        return mav;
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public ModelAndView insert(Category category){
        System.out.println(category.toString());
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/category");
        return mav;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ModelAndView delete(Category category){
        categoryService.delete(category.getId());
        ModelAndView mav = new ModelAndView("redirect:/category");
        return mav;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView edit(Category category){
        ModelAndView mav = new ModelAndView("editCategory");
        Category c = categoryService.get(category.getId());
        mav.addObject("c", c);
        return mav;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public ModelAndView update(Category c){
        categoryService.update(c);
        ModelAndView mav = new ModelAndView("redirect:/category");
        return mav;
    }
}
