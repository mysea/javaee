package test;

import bean.Category;
import mapper.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MyBatisTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testAdd(){
        for (int i = 0; i < 100; i++) {
            Category category = new Category();
            category.setName("c" + i);
            categoryMapper.add(category);
        }
    }

    @Test
    public void total(){
        System.out.println(categoryMapper.count());
    }

    @Test
    public void testList(){
        System.out.println(categoryMapper);
        List<Category> categories = categoryMapper.list();
        for (Category c : categories){
            System.out.println(c.getName());
        }
    }
}
