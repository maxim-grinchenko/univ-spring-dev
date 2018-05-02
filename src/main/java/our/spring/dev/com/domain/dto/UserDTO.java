package our.spring.dev.com.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import our.spring.dev.com.domain.dto.base.BaseDTO;

@Getter
@Setter
@ToString(callSuper = true)
public class UserDTO extends BaseDTO {
    private String name;
    private String lastName;
    private String middleName;
    private String phone;
    private String email;
}