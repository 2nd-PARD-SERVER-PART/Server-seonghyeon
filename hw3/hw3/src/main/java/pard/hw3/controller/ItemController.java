package pard.hw3.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pard.hw3.dto.ItemDto;
import pard.hw3.dto.ResponseDto;
import pard.hw3.entity.ItemEntity;
import pard.hw3.service.ItemService;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public ResponseDto<ItemDto> addItem(@RequestBody ItemDto dto) {
        ResponseDto<ItemDto> result = itemService.addItem(dto);

        return result;
    }

    @GetMapping("/findAll")
    public ResponseDto<List<ItemEntity>> findAll() {
        ResponseDto<List<ItemEntity>> result = itemService.findAll();

        return result;
    }

    @GetMapping("/findOne/{itemId}")
    public ResponseDto<ItemEntity> findOne(@PathVariable Integer itemId) {
        ResponseDto<ItemEntity> result = itemService.findOne(itemId);

        return result;
    }

    @PatchMapping("/update/{itemId}")
    public ResponseDto<ItemEntity> itemUpdate(@PathVariable Integer itemId, @RequestBody ItemDto dto) {
        ResponseDto<ItemEntity> result = itemService.itemUpdate(itemId, dto);

        return result;
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseDto<?> itemDelete(@PathVariable Integer itemId) {
        ResponseDto<?> result = itemService.itemDelete(itemId);

        return result;
    }
}
