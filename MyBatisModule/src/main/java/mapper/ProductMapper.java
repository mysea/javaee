package mapper;

import entity.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ProductMapper {
    @Select("select * from product where cid = #{cid}")
    List<Product> getProductsByCid(int cid);

    @Select("select * from product")
    @Results({@Result(property = "category", column = "cid", one = @One(select = "mapper.CategoryMapper.getCategoryById"))})
    List<Product> getProducts();

    @Select("select * from product where id = #{id}")
    Product getProductById(int id);

}
