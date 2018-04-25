package dao;

import entity.Order;
import entity.OrderItem;
import entity.Product;
import mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderDao {

    //xml方式，多对多
    public void manyToManyXml(SqlSession sqlSession){
        //查询订单
        List<Order> orders = sqlSession.selectList("listOrder");
//        List<Order> orders = sqlSession.selectOne("getOrderById", 1);
        for (Order o : orders) {
            System.out.println(o.getCode());
            List<OrderItem> orderItems = o.getOrderItems();
            for (OrderItem oi : orderItems){
                Product p = oi.getProduct();
                System.out.format("\t%s\t%f\t%d%n", p.getName(), p.getPrice(), oi.getNumber());
            }
        }
    }

    public void manyToMany(SqlSession sqlSession){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.getOrders();
        for (Order o : orders) {
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            for (OrderItem oi : ois) {
                Product p = oi.getProduct();
                System.out.println("名称：" + p.getName() + "价格：" + p.getPrice() + "数量：" +oi.getNumber());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        OrderDao orderDao = new OrderDao();

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        orderDao.manyToManyXml(sqlSession);
        orderDao.manyToMany(sqlSession);


        sqlSession.commit();
        sqlSession.close();
    }
}
