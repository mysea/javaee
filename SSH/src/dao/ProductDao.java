package dao;

import bean.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> list();
    public void add(Product p);
}
