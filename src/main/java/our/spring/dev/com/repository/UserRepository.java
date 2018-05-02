package our.spring.dev.com.repository;


import our.spring.dev.com.domain.entity.User;

import java.util.List;

public interface UserRepository {
    void delete(User user);

    void deleteAll();

    boolean existsById(long id);

    List<User> findAll();

    User findById(long id);

    User save(User user);

    void saveAll(List<User> users);
}