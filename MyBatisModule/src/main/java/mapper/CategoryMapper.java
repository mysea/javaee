package mapper;

import entity.Category;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {
    @Select("select * from category where id = #{id}")
    Category getCategoryById(int id);

    @Select("select * from category")
    @Results({@Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "mapper.ProductMapper.getProductsByCid"))})
    List<Category> getCategories();
}
