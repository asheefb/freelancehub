package com.asheef.user_service.controller;

import com.asheef.common_utils.response.ResponseDto;
import com.asheef.user_service.dto.UpdateUserDto;
import com.asheef.user_service.dto.UserDto;
import com.asheef.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addUser(@Valid @RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(updateUserDto);
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<ResponseDto> findUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<ResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<ResponseDto> getUserDetailsById(String id) {
        return userService.getUserDetailsById(id);
    }
}
