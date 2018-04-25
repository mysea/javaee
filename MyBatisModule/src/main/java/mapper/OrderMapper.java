package mapper;

import entity.Order;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface OrderMapper {
    @Select("select * from order")
    @Results({@Result(property = "orderItems", javaType = List.class, column = "id", many = @Many(select = "mapper.OrderItemMapper.getOrderItemById"))})
    List<Order> getOrders();
}
