package com.asheef.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

    @NotNull(message = "Id is required")
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @Size(max = 300, message = "Bio is too long")
    private String bio;

    private String profilePictureUrl;

    @Size(max = 100, message = "Contact info too long")
    private String contactInfo;
}
