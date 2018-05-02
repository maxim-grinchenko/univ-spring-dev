package our.spring.dev.com.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import our.spring.dev.com.configuration.AppConfig;
import our.spring.dev.com.domain.entity.User;
import our.spring.dev.com.util.TestUtil;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author vkononenko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void save() {
        User user = repository.save(TestUtil.createUser());
        System.out.println(user.toString());
        assertNotNull(user);
    }

    @Test
    public void update() {
        User user = TestUtil.createUser();
        user.setId(2);
        System.out.println(user);

        user = repository.save(user);
        System.out.println(user.toString());
        assertNotNull(user);
    }

    @Test
    public void deleteById() {
        User user = repository.findById(2);
        repository.delete(user);
    }

    @Test
    public void deleteAll() {
        repository.deleteAll();
    }

    @Test
    public void findById() {
        User user = repository.findById(7L);
        System.out.println(user.toString());
        assertNotNull(user);
    }

    @Test
    public void findAll() {
        List<User> users = repository.findAll();
        System.out.println(users.toString());
        assertNotNull(users);
    }
}