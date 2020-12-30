package com.example.demo.repository;

import com.example.demo.domain.ComplexKey;
import com.example.demo.domain.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryItemRepository extends JpaRepository<ItemCategory, ComplexKey> {

    List<ItemCategory> findByIdCategory(String category);
    List<ItemCategory> findByIdItem(String item);
}
