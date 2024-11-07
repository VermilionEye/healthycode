package ru.tsarev.healthycode.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tsarev.healthycode.entities.User;
import ru.tsarev.healthycode.repositories.RoleRepository;
import ru.tsarev.healthycode.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of(roleRepository.findRoleById(0)));
            userRepository.save(user);
        }
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }
}
