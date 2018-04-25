package com.spring.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.springboot.entity.Category;
import com.spring.springboot.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
//    @Autowired
//    CategoryDao categoryDao;

    @Autowired
    CategoryMapper categoryMapper;

//    @RequestMapping("/list")
//    public String list(Model m, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size){
//        Sort sort = new Sort(Sort.Direction.ASC,"id");
//        Pageable pageable = new PageRequest(start, size, sort);
//
//        Page page = categoryDao.findAll(pageable);
//        m.addAttribute("page",page);
//        return "listCategory";
//    }

    @RequestMapping("/list")
    public String list(Model m, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size){
        PageHelper.startPage(start,size,"id asc");
        List<Category> categories = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(categories);
        m.addAttribute("page",page);
        return "listCategory";
    }

    @RequestMapping("/add")
    public String add(Category category){
//        categoryDao.save(category);
        categoryMapper.save(category);
        return "redirect:/category/list";
    }

    @RequestMapping("/delete")
    public String delete(Category category){
//        categoryDao.delete(category);
        categoryMapper.delete(category.getId());
        return "redirect:/category/list";
    }

    @RequestMapping("/update")
    public String update(Category category){
//        categoryDao.save(category);
        categoryMapper.update(category);
        return "redirect:/category/list";
    }

    @RequestMapping("/get")
    public String get(int id, Model m){
//        Category category = categoryDao.getOne(id);
        Category category = categoryMapper.get(id);
        m.addAttribute("c",category);
        return "editCategory";
    }
}
