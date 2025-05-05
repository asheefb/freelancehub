package com.asheef.common_utils.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {


    private Boolean success;

    private Integer statusCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> errors;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    public ResponseDto(Boolean success, Integer statusCode) {
        this.success = success;
        this.statusCode = statusCode;
    }

    public ResponseDto(Boolean success ,Object data, Integer statusCode, String msg) {
        this.success = success;
        this.data = data;
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public ResponseDto(Boolean success, String msg, Integer statusCode, String error) {
        this.success = success;
        this.msg = msg;
        this.statusCode = statusCode;
        this.error = error;
    }


    public ResponseDto(Boolean success, Integer statusCode, Object data) {
        this.success = success;
        this.statusCode = statusCode;
        this.data = data;
    }



    public ResponseDto(Boolean success, Integer statusCode, Object data, String msg) {
        this.success = success;
        this.statusCode = statusCode;
        this.data = data;
        this.msg = msg;
    }

    public ResponseDto(Boolean success, Integer statusCode, List<Object> data, String msg,Date timestamp) {
        this.success = success;
        this.statusCode = statusCode;
        this.data = data;
        this.msg = msg;
        this.timestamp = timestamp;
    }


    public ResponseDto(Boolean success, Integer statusCode, String error) {
        this.success = success;
        this.statusCode = statusCode;
        this.error = error;
    }


    public ResponseDto(Boolean success, Integer statusCode, List<Object> errors) {
        this.success = success;
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public ResponseDto(Boolean success, Integer statusCode, List<Object> errors, Date timestamp) {
        this.success = success;
        this.statusCode = statusCode;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public ResponseDto(Boolean success, Integer statusCode, List<Object> errors, String error) {
        this.success = success;
        this.statusCode = statusCode;
        this.errors = errors;
        this.error = error;

//    private Boolean success;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String msg;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private Integer errorCode;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String errorMsg;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private Object data;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private List<Object> listData;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//    private Date timestamp;
//
//    public ResponseDto(Boolean success,String status, Object data) {
//        this.success = success;
//        this.msg = status;
//        this.data = data;
//    }
//
//    public ResponseDto(Boolean success,String status, Object data, String errorMsg, Date timestamp) {
//        this.msg = status;
//        this.success = success;
//        this.data = data;
//        this.errorMsg = errorMsg;
//        this.timestamp = timestamp;
//    }
//
//    public ResponseDto(Boolean success,String status, Integer errorCode, String errorMsg, Date timestamp) {
//        this.msg = status;
//        this.success = success;
//        this.errorMsg = errorMsg;
//        this.errorCode = errorCode;
//        this.timestamp = timestamp;
//    }
//
//    public ResponseDto(Boolean success,String status, String errorMsg, Date timestamp) {
//        this.msg = status;
//        this.success = success;
//        this.errorMsg = errorMsg;
//        this.timestamp = timestamp;
//    }
//
//    public ResponseDto(Boolean success) {
//        this.success = success;
//    }

    }

}