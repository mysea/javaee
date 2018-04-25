package action;

import bean.Category;
import bean.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Namespace("/")
@ParentPackage("struts-default")
@Results({@Result(name = "show", location = "/show.jsp"),@Result(name = "list",location = "/list.jsp"),@Result(name = "category",location = "/category.jsp")})
public class ProductAction extends ActionSupport{
    private Product product;
    private List<Product> products;
    private List<Integer> selectedProducts;
    private List<Category> categories;
    private Date date;
    private String name;

//    xml方式配置：将同文件包下的文件名改成ProductAction-validation.xml
//    启用了表单验证后listProduct和listCategory就失效了？？？
//    public void validate(){
//        if (product.getName().length() == 0){
//            addFieldError("product.name", "商品名称不能为空");
//        }
//    }

    public String addPage(){
        name = "default name";
        return "addPage";
    }

    @Action("listProduct")
    public String list(){
        products = new ArrayList<>();
        selectedProducts = new ArrayList<>();

        Product product1 = new Product("i1",2000f);
        Product product2 = new Product("i2",2000f);
        Product product3 = new Product("i3",2000f);
        Product product4 = new Product("i4",2000f);
        Product product5 = new Product("i5",2000f);

        selectedProducts.add(1);
        selectedProducts.add(2);
        selectedProducts.add(3);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        return "list";
    }
    @Action("listCategory")
    public String listCategory(){
        Product p1 = new Product("p1",1f);
        Product p2 = new Product("p2",2f);
        List<Product> products1 = new ArrayList<>();
        products1.add(p1);
        products1.add(p2);

        Product p3 = new Product("p3",1f);
        Product p4 = new Product("p4",2f);
        List<Product> products2 = new ArrayList<>();
        products2.add(p3);
        products2.add(p4);

        Category c1 = new Category();
        c1.setId(1);
        c1.setName("c1");
        c1.setProducts(products1);
        Category c2 = new Category();
        c2.setId(2);
        c2.setName("c2");
        c2.setProducts(products2);

        categories = new ArrayList<>();
        categories.add(c1);
        categories.add(c2);

        return "category";
    }

    @Action("showProduct")
    public String show(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        System.out.println("request: " + request);
        System.out.println("response: " + response);

        product = new Product();
        product.setName("小米 mix2s");
        product.setPrice(3999f);
        return "show";
    }

    public String add(){
        Map m = ActionContext.getContext().getSession();
        m.put("name", product.getName());
        m.put("price", product.getPrice());
//        System.out.println("product name:" + product.getName());
        return "show";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Integer> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Integer> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
