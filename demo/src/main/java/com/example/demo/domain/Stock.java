package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Stock {
    private Long stockId;
    private String stockName;

    private float currentPrice;
    private float highPrice;
    private float lowPrice;

    private long tradeTime;
    private long   volume;


    public Stock(){
    }

    public Stock(Long stockId, String stockName, float currentPrice, float highPrice, float lowPrice, long tradeTime, long volume) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.currentPrice = currentPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradeTime = tradeTime;
        this.volume=volume;
    }

}
