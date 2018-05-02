package our.spring.dev.com.infra.transformer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import our.spring.dev.com.configuration.AppConfig;
import our.spring.dev.com.domain.dto.UserDTO;
import our.spring.dev.com.domain.entity.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    public void userToUserDTO() {
        User user = new User();
        user.setId(1L);
        user.setName("some name");
        user.setLastName("some last name");
        user.setMiddleName("some middle name");
        user.setLogin("some login");
        user.setLogin("some password");

        UserDTO userDTO = mapper.userToUserDTO(user);
        System.out.println(userDTO);

        assertNotNull(userDTO);
        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getLastName(), userDTO.getLastName());
        assertEquals(user.getMiddleName(), userDTO.getMiddleName());
    }

    @Test
    public void userDTOtoUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("some name");
        userDTO.setLastName("some last name");
        userDTO.setMiddleName("some middle name");

        User user = mapper.userDTOtoUser(userDTO);
        System.out.println(userDTO);

        assertNotNull(user);
        assertEquals(userDTO.getName(), user.getName());
        assertEquals(userDTO.getLastName(), user.getLastName());
        assertEquals(userDTO.getMiddleName(), user.getMiddleName());
    }
}