package com.asheef.user_service.service_impl;

import com.asheef.common_models.models.User;
import com.asheef.common_models.repository.UserRepository;
import com.asheef.common_utils.response.ResponseDto;
import com.asheef.user_service.constants.Constant;
import com.asheef.user_service.dto.UpdateUserDto;
import com.asheef.user_service.dto.UserDto;
import com.asheef.user_service.dto.UserListDto;
import com.asheef.user_service.dto.ValidateUserDto;
import com.asheef.user_service.exception.UserNotFoundException;
import com.asheef.user_service.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<ResponseDto> addUser(UserDto userDto) {
        ResponseDto response;
        HttpStatus httpStatus;

        try {
            // Create a new User entity from the UserDto
            User user = new User();
            user.setEmail(userDto.getEmail());
            String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
            user.setPassword(encryptedPassword);

            user.setRole(User.Role.valueOf(userDto.getRole().toUpperCase()));
            user.setName(userDto.getName());
            user.setBio(userDto.getBio());
            user.setProfilePictureUrl(userDto.getProfilePictureUrl());
            user.setContactInfo(userDto.getContactInfo());

            userRepository.save(user);

            response = new ResponseDto(Boolean.TRUE, Constant.SUCCESS_MESSAGE, HttpStatus.OK.value(), "SUCCESS");
            httpStatus = HttpStatus.OK;

        } catch (IllegalArgumentException e) {
            response = new ResponseDto(Boolean.FALSE, Constant.INVALID_ROLE, HttpStatus.BAD_REQUEST.value(), "ERROR");
            httpStatus = HttpStatus.BAD_REQUEST;

        } catch (Exception e) {
            response = new ResponseDto(Boolean.FALSE, Constant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<ResponseDto> validateUser(ValidateUserDto dto) {
        Optional<User> optionalUser = userRepository.findByEmail(dto.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
                return ResponseEntity.ok(new ResponseDto(Boolean.TRUE, user, HttpStatus.OK.value(), "User validated"));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ResponseDto(Boolean.FALSE, HttpStatus.UNAUTHORIZED.value(), "Invalid email or password"));
    }


    @Override
    public ResponseEntity<ResponseDto> findUserByEmail(String email) {

        ResponseDto response;
        HttpStatus httpStatus;

        try {
            if (StringUtils.isBlank(email)) {
                response = new ResponseDto(Boolean.FALSE, email, HttpStatus.BAD_REQUEST.value(), Constant.EMAIL_SHOULD_NOT_BE_EMPTY);
                httpStatus = HttpStatus.BAD_REQUEST;
                return new ResponseEntity<>(response, httpStatus);
            }
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException(Constant.USER_NOT_FOUND_WITH_EMAIL + email));

            response = new ResponseDto(Boolean.TRUE, Constant.USER_FOUND, HttpStatus.OK.value(), Constant.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (NoSuchElementException e) {
            response = new ResponseDto(Boolean.FALSE, Constant.USER_NOT_FOUND, HttpStatus.NOT_FOUND.value(), "ERROR");
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            response = new ResponseDto(Boolean.FALSE, Constant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, httpStatus);

    }

    @Override
    public ResponseEntity<ResponseDto> updateUser(UpdateUserDto updateUserDto) {

        ResponseDto response;
        HttpStatus httpStatus;

        try {
            User user = userRepository.findById(updateUserDto.getId())
                    .orElseThrow(() -> new UserNotFoundException(Constant.USER_NOT_FOUND_WITH_ID + updateUserDto.getId()));

            if (!updateUserDto.getName().equals(user.getName()))
                user.setName(updateUserDto.getName());

            if (!updateUserDto.getBio().equals(user.getBio()))
                user.setBio(updateUserDto.getBio());

            if (!updateUserDto.getProfilePictureUrl().equals(user.getProfilePictureUrl()))
                user.setProfilePictureUrl(updateUserDto.getProfilePictureUrl());

            if (!updateUserDto.getContactInfo().equals(user.getContactInfo()))
                user.setContactInfo(updateUserDto.getContactInfo());

            userRepository.save(user);

            response = new ResponseDto(Boolean.TRUE, Constant.SUCCESS_MESSAGE, HttpStatus.OK.value(), Constant.SUCCESS);
            httpStatus = HttpStatus.OK;

        } catch (UserNotFoundException e) {
            response = new ResponseDto(Boolean.FALSE, Constant.USER_NOT_FOUND, HttpStatus.NOT_FOUND.value(), Constant.ERROR);
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            response = new ResponseDto(Boolean.FALSE, Constant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value(), Constant.ERROR);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<ResponseDto> getAllUsers(UserListDto dto) {

        ResponseDto response;
        HttpStatus httpStatus;

        try {
            List<User> users = userRepository.findAll();

            if (users.isEmpty()) {
                response = new ResponseDto(Boolean.FALSE, Constant.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value(), Constant.ERROR);
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response = new ResponseDto(Boolean.TRUE, users, HttpStatus.OK.value(), Constant.SUCCESS);
                httpStatus = HttpStatus.OK;
            }

        } catch (Exception e) {
            response = new ResponseDto(Boolean.FALSE, Constant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value(), Constant.ERROR);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<ResponseDto> getUserDetailsById(String id) {
        return null;
    }
}
