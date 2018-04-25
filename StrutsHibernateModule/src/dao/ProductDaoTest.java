package dao;

import bean.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductDaoTest {
    ProductDao productDao = new ProductDao();

    @Test
    public void add() throws Exception {
        Product product = new Product("查令十字街84号", 29);
        productDao.add(product);
    }

    @Test
    public void delete() throws Exception {
        productDao.delete(30);
    }

    @Test
    public void update() throws Exception {
        Product p = productDao.get(31);
        p.setPrice(25.9f);
        productDao.update(p);
    }

    @Test
    public void get() throws Exception {
        Product p = productDao.get(31);
        Assert.assertEquals("查令十字街84号", p.getName());
    }

    @Test
    public void list() throws Exception {
        List<Product> products = productDao.list();
        Assert.assertEquals(22, products.size());
    }

}