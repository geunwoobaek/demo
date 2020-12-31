package com.example.demo.domain;

import com.example.demo.domain.item.Item;
import com.example.demo.repository.ItemCategoryRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ItemCategoryTest {
    @Autowired
    ItemCategoryRepository itemCategoryRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CategoryRepository categoryRepository;

    //M:N조인 확인
    @Test
    void ValidTest() {
        List<Item> itemList=itemRepository.findAll();
        List<Category> categoryList=categoryRepository.findAll();
        List<ItemCategory> categoryItemList= itemCategoryRepository.findAll();
        System.out.println(itemList.stream().map(o->(o.getName())));
        System.out.println(categoryList.stream().map(o->(o.getName())));
        System.out.println(categoryItemList.stream().map(o->(o.toString())));
        return;
    }
}