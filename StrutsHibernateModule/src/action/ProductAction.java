package action;

import bean.Product;
import dao.ProductDao;

import java.util.List;

public class ProductAction {
    ProductDao productDao = new ProductDao();
    Product product;
    List<Product> products;

    public String add(){
        productDao.add(product);
        return "list";
    }

    public String delete(){
        productDao.delete(product.getId());
        return "list";
    }

    public String update(){
        productDao.update(product);
        return "list";
    }

    public String edit(){
        product = productDao.get(product.getId());
        return "edit";
    }

    public String list(){
        products = productDao.list();
        return "listJsp";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
