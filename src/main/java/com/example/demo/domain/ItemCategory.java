package com.example.demo.domain;

import com.example.demo.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ItemCategory {

   @EmbeddedId
   private CompositeKey id=new CompositeKey();

   @ManyToOne
   @MapsId("categoryId")
   @JoinColumn(name = "category_id")
   private Category category;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderAmount;

}
