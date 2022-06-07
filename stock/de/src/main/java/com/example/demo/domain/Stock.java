package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Stock {
    Long stockId;
    String stockName;

    float currentPrice;
    float highPrice;
    float lowPrice;

    long tradeTime;
    long   volume;

    //int tradeQty;
    //Date highestDate;


    public Stock(){
    }

    public Stock(Long stockId, String stockName, float currentPrice, float highPrice, float lowPrice, long tradeTime) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.currentPrice = currentPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradeTime = tradeTime;
    }

}
