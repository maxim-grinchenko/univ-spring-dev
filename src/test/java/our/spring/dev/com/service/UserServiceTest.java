package our.spring.dev.com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import our.spring.dev.com.configuration.AppConfig;
import our.spring.dev.com.domain.entity.User;
import our.spring.dev.com.infra.exception.ValidationException;
import our.spring.dev.com.repository.UserRepository;
import our.spring.dev.com.util.TestUtil;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
public class UserServiceTest {
    @Autowired
    private UserService service;
    @Autowired
    private UserRepository repository;

    @Test
    public void saveUser() {
        User user = TestUtil.createUser();
        user = service.saveUser(user);

        assertNotNull(user);

        List<User> users = repository.findAll();
        assertFalse(users.isEmpty());
        assertTrue(users.size() == 1);

        assertEquals(1, users.get(0).getId());
        assertEquals(user.getName(), users.get(0).getName());
        assertEquals(user.getLastName(), users.get(0).getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveUserNull() {
        User user;
        user = service.saveUser(null);

        assertNull(user);
        assertTrue(repository.findAll().isEmpty());
    }

    @Test(expected = ValidationException.class)
    public void saveUserBadPassword() {
        User user = TestUtil.createUser();
        user.setPassword("2122");

        service.saveUser(user);
    }

    @Test(expected = ValidationException.class)
    public void saveBadPhone() {
        User user = TestUtil.createUser();
        user.setPhone("032842");

        service.saveUser(user);
    }

    @Test
    public void findUserById() {
        User user = TestUtil.createUser();
        user = repository.save(user);

        Optional<User> foundUser = service.findUserById(1);
        System.out.println(foundUser);

        assertTrue(foundUser.isPresent());
        assertEquals(user.getId(), foundUser.get().getId());
    }

    @Test
    public void notFoundUserById() {
        Optional<User> foundUser = service.findUserById(1_000_000L);
        System.out.println(foundUser);

        assertFalse(foundUser.isPresent());
    }

    @Test
    public void findAllUsers() {
        repository.save(TestUtil.createUser());
        repository.save(TestUtil.createUser());

        List<User> users = service.findAllUsers();
        System.out.println(users);

        assertFalse(users.isEmpty());
        assertTrue(users.size() == 2);
    }
}