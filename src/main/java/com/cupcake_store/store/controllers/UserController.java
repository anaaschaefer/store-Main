package com.cupcake_store.store.controllers;

import com.cupcake_store.store.entities.User;
import com.cupcake_store.store.entities.enums.UserType;
import com.cupcake_store.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findAll(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        if(user.getUserType() == null){
            user.setUserType(UserType.USER);
        }
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("Usuario deletado com sucesso!");
    }
}
