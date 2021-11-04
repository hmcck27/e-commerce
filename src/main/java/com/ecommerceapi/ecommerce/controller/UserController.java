package com.ecommerceapi.ecommerce.controller;

import com.ecommerceapi.ecommerce.dto.UserSignUpDto;
import com.ecommerceapi.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity signUp(
            @Valid UserSignUpDto userSignUpDto) {



    }

    @CrossOrigin
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ResponseEntity signIn(
            @Valid UserSignInDto userSignInDto
    ) {

    }

}
