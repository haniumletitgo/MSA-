package trade.web.api.controller;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trade.domain.TradeType;

@RestController
@RequestMapping("/api")
public class TradeController {

    /**
     * id로 단건 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/trades/{id}")
    public TradeDto findOne(@PathVariable("id") Long id) {
        //Trade trade = tradeService.findById(id);
        return new TradeDto();
    }

    /**
     * 전체 조회
     *
     * @return
     */
    @GetMapping("/trades")
    public ResponseList<ArrayList<TradeDto>> findAll() {
        //Trade trade = tradeService.findAll();
        return new ResponseList<ArrayList<TradeDto>>(0, new ArrayList<>());
    }


    /**
     * 특정 맴버 시간기준 페이지 조회
     *
     * @param memberId
     * @param sortRule
     * @param limit
     * @param offset
     * @param tradeType
     * @return
     */
    @GetMapping("/members/{id}/trades")
    public ResponseList<ArrayList<FindByMemberAndPageResponse>> findByMemberAndPage(
        @PathVariable("id") Long memberId,
        @RequestParam(value = "sort", defaultValue = "time:asc") String sortRule,
        @RequestParam(value = "limit", defaultValue = "20") String limit,
        @RequestParam(value = "offset", defaultValue = "0") Integer offset,
        @RequestParam(value = "transaction_type", defaultValue = "") TradeType tradeType) {

        return new ResponseList<>(0, new ArrayList<>());
    }

    /**
     * 유효한 매수, 매도 호가 (가격, 개수)반환
     * @param orderId
     * @return
     */
    @GetMapping("/orders/{id}/trades")
    public ResponseList<ArrayList<FindByOrderAndAggreagationResponse>> findByOrderAndAggregation(
        @PathVariable("id") Long orderId) {

        return new ResponseList<>(0, new ArrayList<>());
    }

    /**
     * 호가 등록(매도, 매수) 예약 개념은 없다고 가정.
     *
     * @param request
     * @return
     */
    @PostMapping("/trades")
    public ResponseEntity<BidOrAskResponse> bidOrAsk(@RequestBody @Valid BidOrAskRequest request) {
        //1. 매도 혹은 매수 인지 파악
        //2. 매도 혹은 매수 가능 여부 파악
        //3. 2. 에서 불가능 하다면 불가능 이유 return
        //4. 2. 에서 가능하다면 매도 혹은 매수 DB에 추가
        //5. 4. 매도, 매수 각각 거래 가능한 품목 등록 순서대로 검색 후 가능하면 거래 수행 후 로그로 남김
        return new ResponseEntity<BidOrAskResponse>(HttpStatus.OK);
    }


    /**
     * 호가 수정
     *
     * @param id
     * @param request
     * @return
     */
    @PatchMapping("/trades/{id}")
    public PatchTradeResponse patchTrade(@PathVariable("id") Long id,
        @RequestBody List<@Valid  PatchTradeRequest> request) {
        //tradeService.overwriteTrade(request.toEntity);
        return new PatchTradeResponse(id);
    }

    /**
     * 호가 취소
     *
     * @param id
     * @return
     */
    @DeleteMapping("/trades/{id}")
    public DeleteTradeResponse deleteTrade(@PathVariable("id") Long id) {
        //Long deleteId = tradeService.delete(id);
        return new DeleteTradeResponse(id);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class FindByMemberAndPageResponse {

        Long tradeId;
        Long stockId;
        Long stockName;
        TradeType tradeType;
        Long price;
        int amount;
        int availableAmount;
        LocalDateTime createdAt;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class FindByOrderAndAggreagationResponse {
        Long stockName;
        TradeType tradeType;
        Long price;
        int availableAmount;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class ResponseList<T> {

        int count;
        T data;
    }


    @Getter
    @Setter
    static class TradeDto {
        Long tradeId;
        Long stockId;
        Long memberId;
        TradeType tradeType;
        Long price;
        int amount;
        int availableAmount;
        LocalDateTime createdAt;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class BidOrAskRequest {

        @NotNull
        Long stockId;
        @NotNull
        Long price;
        @NotNull
        Integer amount;
        @NotNull
        TradeType tradeType;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class BidOrAskResponse {

    }


    @Getter
    @Setter
    @AllArgsConstructor
    static class PatchTradeRequest {
        @NotNull
        @NotBlank
        @NotEmpty
        String op;

        @NotNull
        @NotBlank
        @NotEmpty
        String field;

        @NotNull
        @NotBlank
        @NotEmpty
        String value;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class PatchTradeResponse {

        Long tradeId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class DeleteTradeResponse {

        Long tradeId;
    }


}
