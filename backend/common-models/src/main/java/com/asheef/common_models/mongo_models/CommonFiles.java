package com.asheef.common_models.mongo_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class CommonFiles {

    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    @Field(value = "file_name")
    private String fileName;

    @Field(value = "file_type")
    private String fileType;

    @Field(value = "file_size")
    private String fileSize;

    @Field(value = "file_path")
    private String filePath;

    @Field(value = "s3_key")
    private String s3Key;

    @Field(targetType = FieldType.OBJECT_ID)
    private String status;

    @Field(value = "collection_name")
    private String collectionName;

    private Date createdAt;

    private Date updatedAt;
}
