package pard.hw2nd.repository;

import org.springframework.stereotype.Repository;
import pard.hw2nd.dto.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GoodsRepository {
    private static final Map<Integer, Goods> goodsList = new HashMap<>();

    //create
    public Goods save(Goods goods) {
        int index = goodsList.size() + 1;
        goods.setId(index);
        goodsList.put(index, goods);

        return goods;
    }

    //read one
    public Goods findById(Integer id) {
        return goodsList.get(id);
    }

    //read all
    public List<Goods> findAll() {
        return new ArrayList<>(goodsList.values());
    }

    //update
    public void update(Integer id, Goods updateParam) {
        Goods findGoods = findById(id);
        findGoods.setName(updateParam.getName());
        findGoods.setPrice(updateParam.getPrice());
        findGoods.setNumber(updateParam.getNumber());
    }

    //delete
    public void delete(Integer id) {
        goodsList.remove(id);
    }
}
