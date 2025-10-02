package com.dev.laedson.crmColumna.service;

import com.dev.laedson.crmColumna.dto.CreateUserDto;
import com.dev.laedson.crmColumna.dto.GetUserDto;
import com.dev.laedson.crmColumna.model.User;
import com.dev.laedson.crmColumna.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {

        var entity = new User(
                null,
                createUserDto.name(),
                createUserDto.telefone(),
                createUserDto.email(),
                createUserDto.password(),
                createUserDto.role()
        );

        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }

    public User getUserById(GetUserDto getUserDto) {

        var user = userRepository.findByEmail(getUserDto.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!(user.getPassword().equals(getUserDto.password()))){
            throw new RuntimeException("Senha incorreta");
        }

        return user;
    }

    public void putUser(UUID userId, String telefone) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setTelefone(telefone);
        userRepository.save(user);
    }

    public void deleteUser(UUID userId) {

        var user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.deleteById(user.getUserId());
    }
}
