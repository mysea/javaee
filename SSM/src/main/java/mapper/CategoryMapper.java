package mapper;

import entity.Category;
import entity.Page;
import java.util.List;

public interface CategoryMapper {
    void add(Category category);
    void delete(int id);
    Category get(int id);
    void update(Category category);
    List<Category> list();
//    List<Category> list(Page page);
//    int count();
}
