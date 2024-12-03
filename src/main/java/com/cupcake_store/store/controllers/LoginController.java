package com.cupcake_store.store.controllers;

import com.cupcake_store.store.entities.dtos.LoginDTO;
import com.cupcake_store.store.entities.dtos.UserDTO;
import com.cupcake_store.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {
        UserDTO user = userService.login(loginDTO.getEmail(), loginDTO.getPassword());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
