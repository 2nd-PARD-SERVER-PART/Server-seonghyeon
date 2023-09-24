package pard.hw2nd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pard.hw2nd.dto.Goods;
import pard.hw2nd.repository.GoodsRepository;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @PostMapping("/add")
    public String goodsAdd(@RequestBody Goods goods) {
        goodsRepository.save(goods);

        return "상품 등록 완료";
    }

    @GetMapping("/findOne/{id}")
    public Goods goodsFineOne(@PathVariable Integer id) {
        Goods goods = goodsRepository.findById(id);

        return goods;
    }

    @GetMapping("/findAll")
    public List<Goods> userFind() {
        List<Goods> findList = goodsRepository.findAll();

        return findList;
    }

    @PatchMapping("/update/{id}")
    public String goodsUpdate(@PathVariable Integer id, @RequestBody Goods goods) {
        goodsRepository.update(id, goods);

        return "상품 수정 완료";
    }

    @DeleteMapping("/delete/{id}")
    public String goodsDelete(@PathVariable Integer id) {
        goodsRepository.delete(id);

        return "상품 삭제 완료";
    }
}
