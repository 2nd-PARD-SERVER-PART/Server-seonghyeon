package com.pard.hw3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import com.pard.hw3.dto.ItemDto;

import java.sql.Timestamp;

@Entity(name = "item") //item 이라는 테이블
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 상품 번호 자동 증가
    private int itemId;
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    @CreationTimestamp
    private Timestamp itemTime;

    public ItemEntity(ItemDto dto) {
        this.itemName = dto.getItemName();
        this.itemPrice = dto.getItemPrice();
        this.itemQuantity = dto.getItemQuantity();
    }
}
