package com.asheef.common_models.mongo_models;

import com.asheef.common_models.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "users")
public class UsersModel {

    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private String email;

    private User.Role role;

    private String name;

    private String bio;

    private String profilePictureUrl;

    private AddressSubDocument addressSubDocument;

    // Active & verification flags
    private boolean isActive = true;
    private boolean verified = false;

    // Social media links as a map: key = platform name, value = URL
    private Map<String, String> socialLinks;

    @Field(targetType = FieldType.OBJECT_ID, name = "created_by")
    private String createdBy;
    // Timestamps
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @Field(targetType = FieldType.OBJECT_ID, name = "updated_by")
    private String updatedBy;

}
