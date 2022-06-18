package trade.web.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import trade.domain.TradeType;

@Getter
@Setter
public class FindByOrderAndAggreagationResponse {
    Long stockName;
    TradeType tradeType;
    Long price;
    int availableAmount;
}
