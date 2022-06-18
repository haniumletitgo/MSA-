package trade.web.api.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import trade.domain.TradeType;

@Getter
@Setter
public class FindByMemberAndPageResponse {
    Long tradeId;
    Long stockId;
    Long stockName;
    TradeType tradeType;
    Long price;
    int amount;
    int availableAmount;
    LocalDateTime createdAt;

}
