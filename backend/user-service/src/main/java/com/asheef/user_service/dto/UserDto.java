package com.asheef.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Role is required") // should be freelancer, client, or admin
    private String role;

    @NotBlank(message = "Name is required")
    private String name;

    @Size(max = 500, message = "Bio is too long (max 500 characters)")
    private String bio;

    private String profilePictureUrl;

    @Size(max = 100, message = "Contact info too long")
    private String contactInfo;
}
