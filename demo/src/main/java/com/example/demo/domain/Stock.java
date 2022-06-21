package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Stock {
    private Long stockId;
    private String stockName;
    private String category;    //업종

    private float currentPrice; //현재가
    private long time;

    //당일기준
    private float highPrice;    //최고가
    private float lowPrice;     //최저가
    private long volume;    //총 거래량
    private float totalPrice;  //총 거래대금
    private float capitalization;   //시가총액


    public Stock(){
    }

    public Stock(String stockName, String category, float currentPrice, long time, float highPrice, float lowPrice, long volume, float totalPrice, float capitalization) {
        this.stockName = stockName;
        this.category = category;
        this.currentPrice = currentPrice;
        this.time = time;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.volume = volume;
        this.totalPrice = totalPrice;
        this.capitalization = capitalization;
    }

}
