package com.example.demo.controller;

import com.example.demo.domain.Stock;
import com.example.demo.domain.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/stocks")
@RequiredArgsConstructor

public class StockController {

    private final StockRepository stockRepository;

    /*전체 주식 정보 조회*/
    @GetMapping
    public String stocks(Model model){
        List<Stock> stocks = StockController.findAll();
        model.addAttribute("stocks", stocks);
        return "api/stocks";
    }

    /*주식 상세정보 조회
    * - 기업 정보
        - 업종
        - 매출액, 영업이익(재무재표 정보)
    - 가격 변동 차트
    - 현재 가격
    - 호가(판매 대기, 구매 대기)(금액 별로)
    - 거래량 통계치 (당일 기준)
        - 1일 최고가, 최저가, 총 거래량, 총 거래대금, 시가총액*/
    @GetMapping("/{stockId}")
    public String stock(@PathVariable long stockId, Model model){
        return "api/stock";
    }

    /*특정기간 거래량 top 10*/
    @GetMapping
    public String stocks(Model model){
        return "api/stocks/{stockId}/more";
    }

    /*특정기간 수익 증감량 top 10*/
    @GetMapping
    public String stocks(Model model){
        return "api /stocks/{stockId}/higher";
    }

    /*주식 정보 생성*/
    @PostMapping("/add")
    public String addStock() {
        return "redirect:/basic/stocks/{stockId}";
    }

    /*주식 정보 수정*/

    /*주식 정보 삭제*/
}
