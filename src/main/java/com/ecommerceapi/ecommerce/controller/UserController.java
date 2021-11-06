package com.ecommerceapi.ecommerce.controller;

import com.ecommerceapi.ecommerce.dto.BearTokenHeader;
import com.ecommerceapi.ecommerce.dto.user.UserSignInDto;
import com.ecommerceapi.ecommerce.dto.user.UserSignUpDto;
import com.ecommerceapi.ecommerce.exception.exception.AlreadyExistUserException;
import com.ecommerceapi.ecommerce.exception.exception.NotExistUserException;
import com.ecommerceapi.ecommerce.response.UserApiResponse;
import com.ecommerceapi.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity userSignUp(
            @Valid @RequestBody UserSignUpDto userSignUpDto
    ) {

        log.info("create user start in controller layer : ", userSignUpDto.toString());

        /**
         * 1. already exist user -> throw new AlreadyExistUserException
         * 2. new user -> return 200
         */

        if (userService.isExistUser(userSignUpDto)) {
            throw new AlreadyExistUserException();
        }

        UserApiResponse userApiResponse = new UserApiResponse(userService.SignUp(userSignUpDto));

        log.info("create user end in controller layer : ", userSignUpDto);
        return new ResponseEntity(userApiResponse, HttpStatus.valueOf(200));
    }

    @CrossOrigin
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ResponseEntity userSignIn(
            @Valid @RequestBody UserSignInDto userSignInDto,
            @RequestHeader BearTokenHeader bearTokenHeader
    ) {

        log.info("user log in start in controller layer : ", userSignInDto.toString());

        /**
         * 1. check proper user
         * 2. return ApiResponse
         */

        if (!userService.isExistUser(userSignInDto)) {
            throw new NotExistUserException();
        }

        if ()

        UserApiResponse userApiResponse = new UserApiResponse(userService.SignIn(userSignInDto));

        log.info("user log in end in controller layer : ", userSignInDto);
        return
    }
}
