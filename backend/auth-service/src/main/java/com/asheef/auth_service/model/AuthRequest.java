package com.asheef.auth_service.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
