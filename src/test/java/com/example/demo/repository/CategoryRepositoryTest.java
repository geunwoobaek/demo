package com.example.demo.repository;
import com.example.demo.domain.Category;
import com.example.demo.domain.item.Item;
import com.example.demo.repository.ItemCategoryRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository repository;
    @Test
    void ValidTest() {
        Category Category1,Category2,Category3;
        Category1=repository.findByName("It");
        Hibernate.initialize(Category1.getChild());
        Category2=repository.findByName("Spring");
        Hibernate.initialize(Category2.getParent()
                .getName());
        Category3=repository.findByName("Back-end");
        Hibernate.initialize(Category3.getParent().getName());

        assert(Category1.getChild().contains(Category2));
        assert(Category2.getParent()==Category1);
        assert(Category3.getParent()==Category1);
    }
}