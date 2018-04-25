package dao;

import bean.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ProductDao {
    public void add(Product p){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.save(p);
        s.beginTransaction().commit();
        s.close();
        sf.close();
    }

    public void delete(int id){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Product p = (Product) s.get(Product.class, id);
        s.delete(p);
        s.beginTransaction().commit();
        s.close();
        sf.close();
    }

    public void update(Product p){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.update(p);
        s.beginTransaction().commit();
        s.close();
        sf.close();
    }

    public Product get(int id){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Product p = (Product) s.get(Product.class,id);
        s.beginTransaction().commit();
        s.close();
        sf.close();
        return p;
    }

    public List<Product> list(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Query query = s.createQuery("from Product p");
        List<Product> products = query.list();
        s.beginTransaction().commit();
        s.close();
        sf.close();

        return products;
    }
}
