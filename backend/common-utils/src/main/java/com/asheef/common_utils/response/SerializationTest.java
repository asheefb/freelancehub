package com.asheef.common_utils.response;

import com.asheef.common_utils.response.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SerializationTest {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // <-- Add this line

        ResponseDto responseDto = new ResponseDto(true, "Success", 200, "Registration successful");
        String json = objectMapper.writeValueAsString(responseDto);
        System.out.println(json);
    }
}
