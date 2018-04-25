package entity;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private float price;
    private Category category;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
