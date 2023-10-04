package pard.hw3.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pard.hw3.dto.ItemDto;
import pard.hw3.dto.ResponseDto;
import pard.hw3.entity.ItemEntity;
import pard.hw3.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //create
    //itemName : 겹치면 추가하지 않게 해주세요 (String)
    //itemPrice : 50000원 이상은 추가 못하도록 해주세요 (Int)
    public ResponseDto<ItemDto> addItem(ItemDto dto) {
        ItemEntity item = new ItemEntity(dto);
        String itemName = dto.getItemName();
        int itemPrice = dto.getItemPrice();

        try {
            if (itemRepository.existsByItemName(itemName)) {
                return ResponseDto.setFailed("이미 존재하는 상품명입니다.");
            }
            if (itemPrice >= 50000) {
                return ResponseDto.setFailed("상품 가격은 50,000 이하여야 합니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }

        try {
            itemRepository.save(item);

            return ResponseDto.setSuccess("add item", dto);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseDto.setFailed("db 오류");
        }
    }

    //read all
    public ResponseDto<List<ItemEntity>> findAll() {
        List<ItemEntity> items;

        try {
            items = itemRepository.findAll();

            return ResponseDto.setSuccess("find all", items);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseDto.setFailed("db 오류");
        }
    }

    //read one
    public ResponseDto<ItemEntity> findOne(Integer itemId) {
        ItemEntity item;

        try {
            //Required type: ItemEntity
            //Provided:Optional
            //<pard.hw3.entity.ItemEntity>
            item = itemRepository.findById(itemId).get();

            return ResponseDto.setSuccess("find one", item);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseDto.setFailed("db 오류");
        }
    }

    //update
    @Transactional
    public ResponseDto<ItemEntity> itemUpdate(Integer itemId, ItemDto dto) {
        ItemEntity item;
        String itemName = dto.getItemName();
        int itemPrice = dto.getItemPrice();

        try {
            if (itemPrice >= 50000) {
                return ResponseDto.setFailed("상품 가격은 50,000 이하여야 합니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }

        try {
            item = itemRepository.findById(itemId).get();

            if (dto.getItemName() != null && !dto.getItemName().isEmpty()) {
                item.setItemName(dto.getItemName());
            }

            return ResponseDto.setSuccess("item update", item);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseDto.setFailed("db 오류");
        }
    }

    //delete
    public ResponseDto<?> itemDelete(Integer itemId) {
        try {
            itemRepository.deleteById(itemId);
            return ResponseDto.setSuccess("item delete", null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("db 오류");
        }
    }
}
