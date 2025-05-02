package com.asheef.common_utils.response;

import lombok.*;

@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {

    private Boolean success;
    private Object data;
    private Integer statusCode;
    private String message;

    public ResponseDto(Boolean success, Integer statusCode, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseDto(Boolean success, String data, Integer statusCode, String message) {
        this.success = success;
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseDto(Boolean success, Object data, Integer statusCode, String message) {
        this.success = success;
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
    }
}
