package app.resource;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<String> auth(@RequestBody User user) {
        if (userService.getUserById(user.getId()) != null) {
            UUID uuid = UUID.randomUUID();
            String s = uuid.toString();
            userService.addKey(s);

            return new ResponseEntity<>(userService.getKeyByKey(s), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<User> getUserById2 (@PathVariable (name = "id") long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}