package com.example.demo.domain;

import com.example.demo.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "order_item")
public class OrderItem {

    @GeneratedValue
    @Id
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("item_id")
    private Item item;
    private int orderPrice;
    private int count;

    public static OrderItem CreateOrderItem(Item item, int orderPrice, int Count) {
        OrderItem orderitem = new OrderItem();
        orderitem.setItem(item);
        orderitem.setCount(Count);
        orderitem.setOrderPrice(orderPrice);
        item.removeStock(Count);
        return orderitem;
    }


    public void cancel() {
        getItem().addStock(count);
    }
}
