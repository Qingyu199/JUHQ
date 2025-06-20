package com.juhq.juhq_backend.controller;

import com.juhq.juhq_backend.model.Item;
import com.juhq.juhq_backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    // 1️⃣ 获取全部物品列表
    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // 2️⃣ 按名称模糊搜索物品
    @GetMapping("/search")
    public List<Item> searchItems(@RequestParam String name) {
        return itemRepository.findByNameContainingIgnoreCase(name);
    }

    // 3️⃣ 添加新物品
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    // 4️⃣ 根据 ID 获取单个物品
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    // 5️⃣ 根据 ID 删除物品
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemRepository.deleteById(id);
    }

    // 6️⃣ 更新物品信息
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item item) {
        item.setItem_id(id);
        return itemRepository.save(item);
    }
}
