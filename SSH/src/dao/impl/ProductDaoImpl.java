package dao.impl;

import bean.Product;
import dao.ProductDao;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class ProductDaoImpl extends HibernateTemplate implements ProductDao {
    @Override
    public List<Product> list() {
        return find("from Product");
    }

    @Override
    public void add(Product p) {
        save(p);
    }
}
