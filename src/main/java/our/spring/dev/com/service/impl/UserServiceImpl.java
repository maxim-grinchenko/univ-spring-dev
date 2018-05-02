package our.spring.dev.com.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.stereotype.Service;
import our.spring.dev.com.domain.entity.User;
import our.spring.dev.com.infra.exception.ValidationException;
import our.spring.dev.com.infra.validation.ValidationFactory;
import our.spring.dev.com.repository.UserRepository;
import our.spring.dev.com.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public Optional<User> findUserById(final long id) {
        LOGGER.info("Find user by id: {}", id);
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public User saveUser(final User user) {
        LOGGER.info("Save user: {}", user);

        Validator validator = ValidationFactory.getValidator();
        validator.disableProfile("UPDATE");

        List<ConstraintViolation> violations = validator.validate(user);
        if (!violations.isEmpty())
            throw new ValidationException("User validation fail", violations);

        // check constrains in db!!!

        // user role
        user.setRoleId(2);
        return repository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        LOGGER.info("Start find all users");
        return repository.findAll();
    }

    @Override
    public void updateUser(final User user) {
        LOGGER.info("Update user: {}", user);

        Validator validator = ValidationFactory.getValidator();
        validator.enableProfile("UPDATE");

        List<ConstraintViolation> violations = validator.validate(user);
        if (!violations.isEmpty())
            throw new ValidationException("User validation fail", violations);
        repository.save(user);
    }
}