package dao;

import entity.Product;
import mapper.ProductMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ProductDao {
    //xml方式，增
    public void insert(SqlSession sqlSession){
        //一般的插入，返回值为1表示插入成功
//        Product product = new Product("hongmi 5",699);
//        int result = sqlSession.insert("insertProduct", product);
//        System.out.println(result == 1 ? "插入成功" : "插入失败");

        //插入后获取主键，没有效果....
//        int num = sqlSession.insert("insertProductReturnId", new Product("oppo R11s", 3299));
//        System.out.println("插入后的主键为：" + num);

        //批量插入
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("iphone7 plus", 3999));
        products.add(new Product("iphone8 plus", 4999));
        products.add(new Product("iphoneX 港行版", 6999));
        int result = sqlSession.insert("insertProducts", products);
        System.out.println("插入成功的条数：" + result);
    }
    //xml方式，删
    public void delete(SqlSession sqlSession){
        //删除单条记录
//        Product product = new Product();
//        product.setId(20);
//        int result = sqlSession.delete("deleteProductById", product);
//        System.out.println(result==1 ? "删除成功" : "删除失败");
        //批量删除

    }
    //xml方式，改
    public void update(SqlSession sqlSession){
        Product p = sqlSession.selectOne("getProductById", 3);
        p.setPrice(7999);
        int result = sqlSession.update("updateProduct", p);
        System.out.println(result == 1 ? "success" : "failure");
    }
    //xml方式，查
    public void query(SqlSession sqlSession){
        //查询所有商品(不传name和id)，根据name模糊查询对应的商品(只传name)，查询id为2的商品(只传id)
        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("name", "mi");
//        params.put("id", 2);
        List<Product> ps = sqlSession.selectList("listProduct", params);
        for (Product p : ps) {
            System.out.println(p.getName() + " : " + p.getPrice());
        }

        //根据id查询单条记录
//        Product p = sqlSession.selectOne("getProductById", 3);
//        System.out.println(p.getName() + ":" + p.getPrice());
    }

    //xml方式的多对一
    public void manyToOneXml(SqlSession sqlSession){
        List<Product> products = sqlSession.selectList("getProductByCid");
        for (Product p : products) {
            System.out.println(p.toString() + " " + p.getCategory());
        }
    }

    //注解方式的多对一
    public void manyToOne(SqlSession sqlSession){
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> products = productMapper.getProducts();
        for (Product p : products) {
            System.out.println(p.toString() + "\t" + p.getCategory().getName());
        }
    }

    public static void main(String[] args) throws IOException {
        ProductDao productDao = new ProductDao();

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sf.openSession();

//        productDao.insert(sqlSession);
//        productDao.delete(sqlSession);
//        productDao.query(sqlSession);
//        productDao.update(sqlSession);

//        productDao.manyToOneXml(sqlSession);
        productDao.manyToOne(sqlSession);

        sqlSession.commit();
        sqlSession.close();
    }
}
