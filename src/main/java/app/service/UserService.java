package app.service;


import app.model.Key;
import app.model.User;
import app.storage.KeyStorage;
import app.storage.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    KeyStorage keyStorage;


    public void addUser (User user) {
        log.info("addUser", user);
        log.trace("addUser trace");
        userRepository.save(user);
    }

    public Optional<User> getUserById (long id) {
        return userRepository.findById(id);
    }

    public void removeUserById (long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public boolean valid (String key) {
        log.warn("notValidKey");
        return keyStorage.keyExists(key);
    }

    public void addKey (String key) {
        log.warn("addKey");
        keyStorage.addKey(key);
    }

    public String getKeyByKey(String s) {
        List<String> allKeys = keyStorage.getAllKeys();

        for (String key : allKeys) {
            if (key.equals(s)) {
                return key;
            }
        }
        return "no such key";
    }

}
