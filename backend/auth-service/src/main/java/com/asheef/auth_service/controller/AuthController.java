package com.asheef.auth_service.controller;

import com.asheef.auth_service.config.JwtUtil;
import com.asheef.auth_service.constant.Constant;
import com.asheef.auth_service.model.AuthRequest;
import com.asheef.auth_service.model.AuthResponse;
import com.asheef.auth_service.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

//    @Autowired
//    private UserService userService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Constant.INVALID_CREDENTIALS);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    // Registration endpoint
//    @PostMapping("/register")
//    public ResponseEntity<ResponseDto> register(@RequestBody UserDto userDto) {
////        try {
//            return userService.addUser(userDto);  // Handle registration logic through UserService
////        } catch (Exception e) {
////            return new ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constant.ERROR_OCCURRED_DURING_REGISTRATION);
////        }
//    }

    // Token refresh endpoint
    @PostMapping("/refresh-token")
    public ResponseEntity<AuthResponse> refreshToken(@RequestParam String refreshToken) {
        try {
            String email = jwtUtil.extractUsername(refreshToken);
            if (email != null && jwtUtil.validateToken(refreshToken, email)) {
                String newToken = jwtUtil.generateToken(email);
                return ResponseEntity.ok(new AuthResponse(newToken));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse(Constant.INVALID_TOKEN));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuthResponse(Constant.ERROR_REFRESHING_TOKEN));
        }
    }

    // Logout endpoint (token invalidation placeholder)
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Token invalidation logic or blacklist handling can be added here
        return ResponseEntity.ok(Constant.LOGOUT_SUCCESS);
    }
}
