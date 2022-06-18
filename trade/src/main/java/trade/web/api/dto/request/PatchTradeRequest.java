package trade.web.api.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatchTradeRequest {
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
