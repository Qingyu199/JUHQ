package com.juhq.juhq_backend.repository;

import com.juhq.juhq_backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    // 通过名称模糊查询
    List<Item> findByNameContainingIgnoreCase(String name);
}
