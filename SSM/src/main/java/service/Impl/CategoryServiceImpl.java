package service.Impl;

import entity.Category;
import entity.Page;
import mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.CategoryService;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public void addTwo() {
        Category c1 = new Category();
        c1.setName("短的名字");
        categoryMapper.add(c1);
        Category c2 = new Category();
        c2.setName("名字太长超过范围就会放不下，就会报错，因为事务原子性，要么不做，要么都做，因此c1,c2都不会被插入数据库中;名字太长超过范围就会放不下，就会报错，因为事务原子性，要么不做，要么都做，因此c1,c2都不会被插入数据库中");
        categoryMapper.add(c2);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }


//    @Override
//    public int total() {
//        return categoryMapper.count();
//    }
//
//    @Override
//    public List<Category> list(Page page) {
//        return categoryMapper.list(page);
//    }
}
