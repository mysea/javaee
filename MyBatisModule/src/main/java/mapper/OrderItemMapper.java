package mapper;

import entity.OrderItem;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderItemMapper {
    @Select("select * from order_item where oid = #{oid}")
    @Results({@Result(property = "product", column = "pid", one = @One(select = "mapper.ProductMapper.getProductById"))})
    List<OrderItem> getOrderItemById(int oid);
}
