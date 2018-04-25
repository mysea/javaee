package dao;

import entity.Category;
import entity.Product;
import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ProductDao {

    public void managerment(Session s){
        //增
//        Product p = new Product();
//        p.setName("huawei mate 10");
//        p.setPrice(7000);
//        s.save(p);

        //删
//        Product p1 = s.get(Product.class, 1);
//        s.delete(p1);

        //改
//        Product p2 = s.get(Product.class, 2);
//        p2.setPrice(4999);
//        s.update(p2);

        /*
        查，有get()和load()两种方式查询
        下列程序执行后控制台输出为：log1，sql语句，sql语句，log2，说明load方法是延迟加载的，当获取对象属性时才执行sql语句，而get()一调用时就执行了sql语句
        */
//        Product p3 = s.load(Product.class, 2);
//        System.out.println("log1");
//        System.out.println(p3.toString());
//
//        Product p4 = s.get(Product.class, 3);
//        System.out.println("log2");

        //查询不存在的记录时，load()抛出异常，而get()返回null
//        System.out.println(s.load(Product.class, 10));
        System.out.println(s.get(Product.class, 10));
    }

    public void hql(Session s){
//        Query q = s.createQuery("from Product p where p.name like ?");
//        String name = "i";
//        q.setParameter(0, "%"+ name +"%");
//
//        List<Product> products = q.list();
//        for (Product p : products) {
//            System.out.println(p.getName() + " : " + p.getPrice());
//        }

        //查询总数
        Query query = s.createQuery("select count(*) from Product");
        System.out.println("总共有 " + query.uniqueResult() + " 条记录");
    }

    public void criteria(Session s){
        String name = "i";

        Criteria criteria = s.createCriteria(Product.class);
        criteria.add(Restrictions.like("name", "%"+ name +"%"));

        //分页查询，从第一行记录开始，总共查询2条数据
//        criteria.setFirstResult(0);
//        criteria.setMaxResults(2);

        List<Product> products = criteria.list();
        for (Product p : products) {
            System.out.println(p.getName());
        }
    }

    public void sql(Session s){
        String name = "i";
        String sql = "select * from product p where p.name like '%" + name + "%'";
        Query query = s.createSQLQuery(sql);
        //因为标准SQL语句有可能返回各种各样的结果，比如多表查询，分组统计结果等等。 不能保证其查询结果能够装进一个Product对象中，所以返回的集合里的每一个元素是一个对象数组。 然后再通过下标把这个对象数组中的数据取出来。
        List<Object[]> oLists = query.list();
        for (Object[] olist : oLists) {
            for (Object o : olist) {
                System.out.print(o + "\t");
            }
            System.out.println();
        }
    }

    public void manyToOne(Session s){
        //将商品2的类目设置为商品类目1
        Category c = s.get(Category.class, 1);
        Product p = s.get(Product.class, 2);
        p.setCategory(c);
        s.update(p);
    }

    public void oneToMany(Session s){
        //获取商品类目1对应的所有商品集合
        Category c = s.get(Category.class, 1);
        Set<Product> products = c.getProducts();
        for (Product p : products) {
            System.out.println(p.getName() + " : " + p.getPrice());
        }
    }

    public void manyToMany(Session s){
        //一个用户购买了三个产品
        User user = s.get(User.class, 1);

        Set<Product> products = new HashSet<>();
        for (int i = 2; i <5; i++) {
            Product product = s.get(Product.class, i);
            products.add(product);
        }

        user.setProducts(products);
    }

    public static void main(String[] args){
        ProductDao productDao = new ProductDao();

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

//        productDao.managerment(s);
//        productDao.hql(s);
//        productDao.criteria(s);
//        productDao.sql(s);

//        productDao.manyToOne(s);
//        productDao.oneToMany(s);
        productDao.manyToMany(s);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
