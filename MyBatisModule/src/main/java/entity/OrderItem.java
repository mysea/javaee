package entity;

import lombok.Data;

@Data
public class OrderItem {
    private int id;
    private int number;
    private Order order;
    private Product product;
}
