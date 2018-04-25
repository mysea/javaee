package entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int id;
    private String code;

    List<OrderItem> orderItems;
}
