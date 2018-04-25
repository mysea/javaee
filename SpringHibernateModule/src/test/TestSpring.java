package test;

import bean.Category;
import dao.CategoryDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

//        Category c1 = (Category) context.getBean("c");
//        System.out.println(c1.getName());

        CategoryDao dao = (CategoryDao) context.getBean("dao");

//        Category c2 = dao.get(Category.class, 2);
//        System.out.println(c2.toString());

//        Category c3 = new Category("book");
//        dao.save(c3);

//        Category c4 = dao.get(Category.class, 117);
//        System.out.println(c4.toString());
//        c4.setName("欧美文学");
//        dao.save(c4);

//        dao.delete(c4);

        //分页查询
//        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
//        int start = 5;
//        int count = 10;
//        List<Category> categories = dao.findByCriteria(dc, start,10);

        //查询全部
//        List<Category> categories = dao.find("from Category c");

        //查询总数
//        List<Long> count = dao.find("select count(*) from Category c");
//        System.out.println(count.get(0));

        //模糊查询
//        List<Category> categories = dao.find("from Category c where c.name like ?","%c%");

        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        dc.add(Restrictions.like("name","%c%"));
        List<Category> categories = dao.findByCriteria(dc);
        for (Category c : categories) {
            System.out.println(c.toString());
        }
    }
}
