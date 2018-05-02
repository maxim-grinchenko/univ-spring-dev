package our.spring.dev.com.domain.dto.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class BaseDTO {
    private long id;
}