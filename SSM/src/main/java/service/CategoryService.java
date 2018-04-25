package service;

import entity.Category;
import entity.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();
//    int total();
//    List<Category> list(Page page);

    void addTwo();

    Category get(int id);
    void add(Category category);
    void delete(int id);
    void update(Category category);
}
