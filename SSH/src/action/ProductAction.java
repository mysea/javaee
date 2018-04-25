package action;

import bean.Product;
import service.ProductService;

import java.util.List;

public class ProductAction {
    ProductService productService;
    List<Product> products;

    public String list() {
        System.out.println(this);
        products = productService.list();
        return "listJsp";
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
