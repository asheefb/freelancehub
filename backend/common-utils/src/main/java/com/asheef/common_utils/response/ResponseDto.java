package com.asheef.common_utils.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private Boolean success;

    private Object data;

    private Integer statusCode;

    private String message;

    public ResponseDto(Boolean success,Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
