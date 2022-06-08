package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StockRepository {
    private static final Map<Long, Stock> store=new HashMap<>();
    private static  long sequence=0L;

    public Stock save(Stock stock){    //상품 저장 기능
        stock.setId(++sequence);
        store.put(item.getId(), stock);
        return stock;
    }

    public Stock findById(Long id){      //조회
        return store.get(id);
    }

    public List<Stock> findAll(){        //전체 조회
        return new ArrayList<>(store.values());
    }

    public void update(Long StockId, Stock updateParam){
        Stock findStock=findById(StockId);
        findStock.setStockName(updateParam.getStockName());
        findStock.setPrice(updateParam.getPrice());
        findStock.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
