package com.example.nba.services;

import com.example.nba.entity.User;
import com.example.nba.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        userRepository.insert(user);
        return user;
    }

    public User updateUser(String id, User updatedUser) {
        User user = verifyUser(id);

        if (user != null) {
            if (!id.equals(updatedUser.getId())) {
                throw new IllegalArgumentException("O ID fornecido não corresponde ao ID do usuário a ser atualizado.");
            }
            BeanUtils.copyProperties(updatedUser, user);
            userRepository.save(user);
        }
        return user;
    }


    public void deleteUser(String id) {
        User user = userRepository.getUserById(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    public User verifyUser(String id) {

        User userFind = userRepository.getUserById(id);
        return userFind;
    }

}
