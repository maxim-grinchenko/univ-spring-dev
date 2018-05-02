package our.spring.dev.com.domain.criteria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserCriteria {
    private List<Long> ids;
    private String name;
    private String lastName;
    private String middleName;
    private String searchStr;
}