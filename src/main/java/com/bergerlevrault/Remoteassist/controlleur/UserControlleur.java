package com.bergerlevrault.Remoteassist.controlleur;

import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.service.UserRaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserControlleur{

    private final UserRaService userRaService;

    public UserControlleur(UserRaService userRaService) {
        this.userRaService = userRaService;
    }

    @PostMapping("/new/users")
    public ResponseEntity<UserRa> createUser(@RequestBody UserRa userDto) {
        UserRa ajouteruser = userRaService.createUser(userDto);
        return new ResponseEntity<>(ajouteruser, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserRa>> getAllUsers() {
        List<UserRa> users = userRaService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("userby/{id}")
    public ResponseEntity<UserRa> getUserById(@PathVariable Long id) {
        Optional<UserRa> user = userRaService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserRa> updateUser(@PathVariable Long id, @RequestBody UserRa userDto) {
        try {
            UserRa updatedUser = userRaService.updateUser(id, userDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRaService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
