package service.impl;

import bean.Product;
import dao.ProductDao;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao;
    public List<Product> list() {
        List<Product> products= productDao.list();
        return products;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
