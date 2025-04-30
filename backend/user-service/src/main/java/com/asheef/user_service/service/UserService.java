package com.asheef.user_service.service;

import com.asheef.common_utils.response.ResponseDto;
import com.asheef.user_service.dto.UpdateUserDto;
import com.asheef.user_service.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<ResponseDto> addUser(UserDto userDto);

    public ResponseEntity<ResponseDto> findUserByEmail(String email);

    public ResponseEntity<ResponseDto> updateUser(UpdateUserDto updateUserDto);

    public ResponseEntity<ResponseDto> getAllUsers();

    public ResponseEntity<ResponseDto> getUserDetailsById(String id);


}
