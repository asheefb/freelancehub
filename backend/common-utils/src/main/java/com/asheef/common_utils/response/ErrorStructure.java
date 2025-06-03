package com.asheef.common_utils.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorStructure {

    private Integer value;

    private String error;

    private String param;

    private List<ErrorStructure> errors;

    public ErrorStructure(int value, String message, String userFound) {
        this.value = value;
        this.error = message;
        this.param = userFound;
    }

    public ErrorStructure(Integer value, List<ErrorStructure> errorList, String  ex) {
        this.value = value;
        this.errors = errorList;
        this.error = ex;
    }

    public ErrorStructure(String rejectedValue, String defaultMessage, String field) {
    }
}
