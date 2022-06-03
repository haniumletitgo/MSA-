package trade.web.api.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import trade.domain.TradeType;

@Getter
@Setter
public class TradeDto {
    Long tradeId;
    Long stockId;
    Long memberId;
    TradeType tradeType;
    Long price;
    int amount;
    int availableAmount;
    LocalDateTime createdAt;

}
