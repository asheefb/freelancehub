package com.asheef.user_service.controller;

import com.asheef.common_utils.response.ResponseDto;
import com.asheef.user_service.dto.UpdateUserDto;
import com.asheef.user_service.dto.UserDto;
import com.asheef.user_service.dto.ValidateUser;
import com.asheef.user_service.dto.ValidateUserDto;
import com.asheef.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@Valid @RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    // Endpoint for user registration is handled by AuthController, so we won't repeat here

    @PostMapping("/validate")
    public ResponseEntity<ResponseDto> validateUser(@ModelAttribute ValidateUserDto validateUserDto) {
        return userService.validateUser(validateUserDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(updateUserDto);
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<ResponseDto> findUserByEmail(@RequestParam String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<ResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<ResponseDto> getUserDetailsById(@RequestParam String id) {
        return userService.getUserDetailsById(id);
    }
}
