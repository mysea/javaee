package dao;

import entity.Order;
import entity.OrderItem;
import entity.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class OrderItemDao {

    public void insert(SqlSession sqlSession){
        Product p = sqlSession.selectOne("getProductById", 3);
        Order o = sqlSession.selectOne("getOrderById",1);
        OrderItem oi = new OrderItem();
        oi.setOrder(o);
        oi.setProduct(p);
        oi.setNumber(100);

        int result = sqlSession.insert("insertOrderItem", oi);
        System.out.println(result == 1 ? "success" : "failure");
    }

    public void delete(SqlSession sqlSession){
        Product p = sqlSession.selectOne("getProductById", 1);
        Order o = sqlSession.selectOne("getOrderById", 1);
        OrderItem oi = new OrderItem();
        oi.setProduct(p);
        oi.setOrder(o);

        int result = sqlSession.delete("deleteOrderItem", oi);
        System.out.println(result == 1 ? "success" : "failure");
    }

    public static void main(String[] args) throws IOException {
        OrderItemDao itemDao = new OrderItemDao();

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        itemDao.insert(sqlSession);
        itemDao.delete(sqlSession);

        sqlSession.commit();
        sqlSession.close();
    }
}
