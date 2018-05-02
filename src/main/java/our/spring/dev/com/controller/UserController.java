package our.spring.dev.com.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import our.spring.dev.com.domain.dto.UserDTO;
import our.spring.dev.com.domain.entity.User;
import our.spring.dev.com.infra.transformer.UserMapper;
import our.spring.dev.com.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vasya
 */
@RestController
@RequestMapping(value = "user/")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    @PostMapping(value = "create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping(value = "find/by/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserDTO findUserById(@PathVariable("id") long id) {
        return service.findUserById(id)
                .map(mapper::userToUserDTO)
                .orElseGet(UserDTO::new);
    }

    @GetMapping(value = "find/all")
    public List<UserDTO> findAllUsers() {
        return service.findAllUsers()
                .stream()
                .map(mapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "update")
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }
}