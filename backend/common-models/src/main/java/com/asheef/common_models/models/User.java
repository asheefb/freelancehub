package com.asheef.common_models.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password; // Store as hashed using BCrypt

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // FREELANCER, CLIENT, ADMIN

    @NotBlank(message = "Name is required")
    private String name;

    @Size(min = 3,max = 300, message = "Bio must be between 3 and 300 characters long")
    private String bio;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    private String line1;

    private String line2;

    @Column(name = "pin_code")
    private Integer pinCode;

    private String city;

    private String state;

    private String country;

    private boolean is_active = true;

    private boolean verified = false;

    private String verificationToken;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public enum Role {
        FREELANCER,
        CLIENT,
        ADMIN
    }
}
