package trade.web.api.dto.request;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import trade.domain.TradeType;

@Getter
@Setter
public class BidOrAskRequest {

    @NotNull
    Long stockId;
    @NotNull
    Long price;
    @NotNull
    Integer amount;
    @NotNull
    TradeType tradeType;

}
