package com.example.demo.repository;

import com.example.demo.domain.Category;
import com.example.demo.domain.CompositeKey;
import com.example.demo.domain.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
