package com.bergerlevrault.Remoteassist.controlleur;

import com.bergerlevrault.Remoteassist.Entity.UserRa;
import com.bergerlevrault.Remoteassist.service.UserRaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
