package our.spring.dev.com.infra.transformer;

import org.mapstruct.Mapper;
import our.spring.dev.com.domain.dto.UserDTO;
import our.spring.dev.com.domain.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);

    User userDTOtoUser(UserDTO userDTO);
}