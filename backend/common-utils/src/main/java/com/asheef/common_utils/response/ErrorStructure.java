package com.asheef.common_utils.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorStructure {

    private String value;

    private String error;

    private String param;

    public ErrorStructure(int value, String message, String userFound) {
        this.value = String.valueOf(value);
        this.error = message;
        this.param = userFound;
    }
}
