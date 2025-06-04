package com.asheef.user_service.dto;

import lombok.Data;

@Data
public class ValidateUserDto {
    private String email;
    private String password;
}
