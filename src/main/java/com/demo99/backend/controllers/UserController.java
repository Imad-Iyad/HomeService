package com.demo99.backend.controllers;

import com.demo99.backend.model.dto.UserReqDTO;
import com.demo99.backend.model.entities.User;
import com.demo99.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/user/{id}")
    public Optional<User> getUserById (@PathVariable Long id){
        return this.userService.getUserById(id);
    }

    @GetMapping(path = "/user")
    public List<User> getAllProviders(){
        return this.userService.getAllProviders();
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserReqDTO userReqDTO){
        return this.userService.UpdateUser(id, userReqDTO);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        return this.userService.deleteUser(id);
    }

}
