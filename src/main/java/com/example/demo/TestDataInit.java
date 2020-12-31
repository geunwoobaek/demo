package com.example.demo;

import com.example.demo.domain.Category;
import com.example.demo.domain.ItemCategory;
import com.example.demo.domain.item.Book;
import com.example.demo.repository.ItemCategoryRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Component
@RequiredArgsConstructor
@Transactional
public class TestDataInit {
    private final EntityManager em;
    private final ItemCategoryRepository itemCategoryRepository;

    private final ItemRepository itemRepository;

    private final CategoryRepository categoryRepository;

    public void InsertBook(){
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.setName("JPA");
        book2.setName("JPA2");
        book3.setName("JPA3");
        itemRepository.save(book1);
        itemRepository.save(book2);
        itemRepository.save(book3);
    }
    public void InsertCategory() {
        Category ParentCategory = new Category();
        Category ChildCategory1 = new Category();
        Category ChildCategory2 = new Category();
        ParentCategory.setName("It");
        ChildCategory1.setName("Spring");
        ChildCategory2.setName("Back-end");
        ParentCategory.addChildCategory(ChildCategory1);
        ParentCategory.addChildCategory(ChildCategory2);
        ChildCategory1.setParent(ParentCategory);
        ChildCategory2.setParent(ParentCategory);
        categoryRepository.save(ParentCategory);
        categoryRepository.save(ChildCategory1);
        categoryRepository.save(ChildCategory2);
    }
    public void InsertItemCategory() {
        ItemCategory itemCategory = new ItemCategory();
        ItemCategory itemCategory2 = new ItemCategory();
        ItemCategory itemCategory3 = new ItemCategory();

        itemCategory.setCategory(categoryRepository.findByName("Spring"));
        itemCategory.setItem(itemRepository.findByName("JPA"));
      //  itemCategory.setting();

        itemCategory2.setCategory(categoryRepository.findByName("Spring"));
        itemCategory2.setItem(itemRepository.findByName("JPA2"));
       // itemCategory2.setting();

        itemCategory3.setCategory(categoryRepository.findByName("Back-end"));
        itemCategory3.setItem(itemRepository.findByName("JPA"));
       // itemCategory3.setting();

        itemCategoryRepository.save(itemCategory);
        itemCategoryRepository.save(itemCategory2);
        itemCategoryRepository.save(itemCategory3);
    }
    @PostConstruct
    public void TestDataInit() {
        InsertBook();
        InsertCategory();
        InsertItemCategory();
    }
}
