package pard.hw2nd.repository;

import org.springframework.stereotype.Repository;
import pard.hw2nd.dto.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GoodsRepository {
    private static final Map<Integer, Goods> goodList = new HashMap<>();

    //create
    public Goods save(Goods goods) {
        goodList.put(goods.getId(), goods);

        return goods;
    }

    //read one
    public Goods findByName(Integer id) {
        return goodList.get(id);
    }

    //read all
    public List<Goods> findAll() {
        return new ArrayList<>(goodList.values());
    }

    //update
    public void update(Integer id, Goods updateParam) {
        Goods findGoods = findByName(id);
        findGoods.setName(updateParam.getName());
        findGoods.setPrice(updateParam.getPrice());
        findGoods.setNumber(updateParam.getNumber());
    }

    //delete
    public void delete(Integer id) {
        goodList.remove(id);
    }
}
