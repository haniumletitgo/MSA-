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
        stock.setStockId(++sequence);
        store.put(stock.getStockId(), stock);
        return stock;
    }


    public static Stock findById(Long stockId){      //조회
        return store.get(stockId);
    }

    public List<Stock> findAll(){        //전체 조회
        return new ArrayList<>(store.values());
    }

    public static void update(Long stockId, Stock updateParam){
        Stock findStock=findById(stockId);
        findStock.setStockName(updateParam.getStockName());
        findStock.setCurrentPrice(updateParam.getCurrentPrice());
        findStock.setVolume(updateParam.getVolume());
    }
    public void clearStore(){
        store.clear();
    }
}
