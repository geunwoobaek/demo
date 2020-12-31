//package com.example.demo.domain;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity @Getter @Setter
//public class Order {
//    @GeneratedValue @Id
//    @Column(name="order_id")
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="member_id")
//    private Member member;
//
//    @OneToMany
//    @JoinColumn(name="orderitem_id")
//    private List<OrderItem> OrderItems=new ArrayList<>();
//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "delivery_id")
//    private Delivery delivery;
//
//    @Enumerated(EnumType.STRING)
//    private OrderStatus status;
//
//    public void addOrderItem(OrderItem item){
//        OrderItems.add(item);
//        item.setOrder(this);
//    }
//}
