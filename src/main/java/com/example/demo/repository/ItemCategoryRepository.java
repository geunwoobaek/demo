package com.example.demo.repository;

import com.example.demo.domain.Category;
import com.example.demo.domain.CompositeKey;
import com.example.demo.domain.ItemCategory;
import com.example.demo.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, CompositeKey> {

    List<ItemCategory> findByIdCategory(String category);
    List<ItemCategory> findByIdItemId(String item);
}
