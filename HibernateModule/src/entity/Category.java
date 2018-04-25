package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    private int id;
    private String name;
    Set<Product> products;

    @OneToMany
    @JoinColumn(name = "cid")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
