package dao;

import entity.Category;
import entity.Product;
import mapper.CategoryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CategoryDao {

    //注解方式，查
    public void getCategoryById(SqlSession sqlSession){
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        Category c = categoryMapper.getCategoryById(1);
        System.out.println(c.getName());
    }

    //注解方式，一对多
    public void oneToMany(SqlSession sqlSession){
        List<Category> categories = sqlSession.selectList("listCategory");
        for (Category c : categories) {
            System.out.println(c.toString());
            List<Product> products =  c.getProducts();
            for (Product p : products) {
                System.out.println("\t" + p.toString());
            }
        }
    }

    //xml方式，一对多
    public void oneToManyXml(SqlSession sqlSession){
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        List<Category> categories = categoryMapper.getCategories();
        for (Category c : categories) {
            System.out.println(c.getName());
            List<Product> products = c.getProducts();
            for (Product p : products) {
                System.out.println("\t" + p.toString());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CategoryDao categoryDao = new CategoryDao();

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sf.openSession();

//        categoryDao.getCategoryById(sqlSession);
//        categoryDao.oneToMany(sqlSession);
        categoryDao.oneToManyXml(sqlSession);

        sqlSession.commit();
        sqlSession.close();
    }
}
