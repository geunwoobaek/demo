package com.example.demo.domain.item;


import com.example.demo.domain.Category;
import com.example.demo.domain.ItemCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<ItemCategory> ItemCategories =new ArrayList<>();

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    //비즈니스로직
    public void removeStock(int howMany){
        if(stockQuantity-howMany<0) throw new RuntimeException("재고가 충분하지 않습니다.");
        this.stockQuantity-=howMany;
    }

}
