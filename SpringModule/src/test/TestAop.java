package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ProductService;

public class TestAop {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});

        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();
    }
}
