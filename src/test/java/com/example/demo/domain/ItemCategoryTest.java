package com.example.demo.domain;

import com.example.demo.domain.item.Book;
import com.example.demo.domain.item.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ItemCategoryTest {
    @PersistenceContext
    EntityManager em;

    @Test
    //M:N조인 확인
    void ValidTest() {
//        Book book1 = new Book();
//        Book book2 = new Book();
//        Category ParentCategory = new Category();
//        Category ChildCategory = new Category();
//
//        book1.setName("JPA");
//        book2.setName("JPA2");
//        ParentCategory.setName("It");
//        ChildCategory.setName("Spring");
//
//        ParentCategory.addChildCategory(ChildCategory);
//        ChildCategory.setParent(ParentCategory);
//
//        em.persist(book1);
//        em.persist(book2);
//        em.persist(ParentCategory);
//        em.persist(ChildCategory);
//
//        ItemCategory itemCategory=new ItemCategory();
//        itemCategory.setItem(book1);
//        itemCategory.setCategory(ParentCategory);
//        em.persist(itemCategory);

    }
}