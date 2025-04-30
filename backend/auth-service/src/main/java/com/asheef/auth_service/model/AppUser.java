package com.asheef.auth_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@Document(collection = "users")
public class AppUser {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String email;
    private String password;
    private String role; // Optional: use for roles/authorities
}