package trade.web.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollectionResponse<T> {

    int count;
    T data;
}
