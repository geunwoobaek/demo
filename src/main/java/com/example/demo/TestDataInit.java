package com.example.demo;

import com.example.demo.domain.Category;
import com.example.demo.domain.ItemCategory;
import com.example.demo.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
@Transactional
public class TestDataInit {
    private final EntityManager em;

    @PostConstruct
    public void TestDataInit() {
        Book book1 = new Book();
        Book book2 = new Book();
        Category ParentCategory = new Category();
        Category ChildCategory = new Category();

        book1.setName("JPA");
        book2.setName("JPA2");
        ParentCategory.setName("It");
        ChildCategory.setName("Spring");
        ParentCategory.addChildCategory(ChildCategory);
        ChildCategory.setParent(ParentCategory);

        em.persist(book1);
        em.persist(book2);
        em.persist(ParentCategory);
        em.persist(ChildCategory);


        ItemCategory itemCategory = new ItemCategory();
    }
}
