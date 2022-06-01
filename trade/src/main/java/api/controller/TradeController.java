package api.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TradeController {



    /**
     * 호가 수정
     * @param id
     * @param request
     * @return
     */
    @PutMapping("/trade/{id}")
    public UpdateTradeResponse updateTrade(@PathVariable("id") Long id, @RequestBody UpdateTradeRequest request) {
        //tradeService.overwriteTrade(request.toEntity);
        return new UpdateTradeResponse(id);
    }

    /**
     * 호가 취소
     * @param id
     * @return
     */
    @DeleteMapping("/trade/{id}")
    public DeleteTradeResponse deleteTrade(@PathVariable("id") Long id) {
        //Long deleteId = tradeService.delete(id);
        return new DeleteTradeResponse(id);
    }

    @Data
    @AllArgsConstructor
    private class UpdateTradeRequest {
        Long tradeId;
        //entity내용과 일치
    }

    @Data
    @AllArgsConstructor
    private class UpdateTradeResponse {
        Long tradeId;
    }

    @Data
    @AllArgsConstructor
    static class DeleteTradeResponse {
        Long tradeId;
    }


}
