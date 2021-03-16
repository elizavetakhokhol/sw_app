package app.service;

import app.model.User;
import app.storage.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Order(1)
    void addUser() {
        User user = new User(1,"test","test","test","hgfdsds@tr.de","trdefggf","5434565",3);
        userRepository.save(user);
        User user1 = new User(2,"test2","test2","test2","hgfdsds@tr.de2","trdefggf2","5434565",4);
        userRepository.save(user1);
        userRepository.getOne(1L);

    }

    @Test
    void getUserById() {
        User user = new User(1,"test","test","test","hgfdsds@tr.de","trdefggf","5434565",3);
        userRepository.save(user);
        userRepository.getOne(1L);
    }
    @Test
    @Order(2)
    void getAllUsers() {
        User user = new User(1,"test","test","test","hgfdsds@tr.de","trdefggf","5434565",3);
        userRepository.save(user);
        User user1 = new User(2,"test2","test2","test2","hgfdsds@tr.de2","trdefggf2","5434565",4);
        userRepository.save(user1);
        userRepository.findAll();
    }

    @Test
    @Order(3)
    void removeUserById() {
        User user = new User(1,"test","test","test","hgfdsds@tr.de","trdefggf","5434565",3);
        userRepository.save(user);
        userRepository.deleteById(1L);
        userRepository.findById(1L);
    }


}