package pard.hw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.hw3.entity.ItemEntity;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    boolean existsByItemName(String itemName); // 검색어에 해당하는 상품이 있는지 확인


    //이름
    List<ItemEntity> findAllByOrderByItemNameDesc(); // 가나다 내림차순 정렬

    List<ItemEntity> findAllByOrderByItemNameAsc(); // 가나다 오름차순 정렬

    //가격
    List<ItemEntity> findAllByOrderByItemPriceDesc(); // 높은 가격 순 정렬

    List<ItemEntity> findAllByOrderByItemPriceAsc(); // 낮은 가격 순 정렬

    //개수
    List<ItemEntity> findAllByOrderByItemQuantityAsc(); // 수량 많이 남은 순 정렬

    List<ItemEntity> findAllByOrderByItemQuantityDesc(); // 수량 적게 남은 순 정렬

    //시간
    List<ItemEntity> findAllByOrderByItemTimeAsc(); // 늦게 등록된 순 정렬

    List<ItemEntity> findAllByOrderByItemTimeDesc(); // 빨리 등록된 순 정렬
}
