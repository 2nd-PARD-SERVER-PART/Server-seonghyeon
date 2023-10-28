package com.pard.hw3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
}
