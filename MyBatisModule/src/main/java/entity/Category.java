package entity;
import lombok.Data;
import java.util.List;

@Data
public class Category {
    private int id;
    private String name;
    private List<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
