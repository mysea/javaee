package test;

import bean.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
//        Category c = (Category) context.getBean("c");
//        System.out.println(c.getName());

        Product p = (Product) context.getBean("p");
        System.out.println(p.getName());
        System.out.println(p.getCategory().getName());
    }
}
