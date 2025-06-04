package com.asheef.common_models.mongo_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressSubDocument {
    // Address fields
    private String line1;

    private String line2;

    private String line3;

    private Integer pinCode;

    private String city;

    private String state;

    private String country;
}
