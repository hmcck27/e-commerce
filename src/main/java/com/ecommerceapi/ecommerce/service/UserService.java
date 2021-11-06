package com.ecommerceapi.ecommerce.service;

import com.ecommerceapi.ecommerce.domain.User;
import com.ecommerceapi.ecommerce.domain.UserToken;
import com.ecommerceapi.ecommerce.dto.UserTokenDto;
import com.ecommerceapi.ecommerce.dto.user.UserSignInDto;
import com.ecommerceapi.ecommerce.dto.user.UserSignUpDto;
import com.ecommerceapi.ecommerce.enums.PlatformType;
import com.ecommerceapi.ecommerce.repository.UserJpaRepository;
import com.ecommerceapi.ecommerce.repository.UserTokenJpaRepository;
import com.ecommerceapi.ecommerce.response.UserSignInResponse;
import com.ecommerceapi.ecommerce.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final UserTokenJpaRepository userTokenJpaRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public boolean isExistUser(UserSignUpDto userSignInDto) {
        int count = userJpaRepository.countUserByPlatformIdAndPlatformType(userSignInDto.getProviderId(), PlatformType.valueOf(userSignInDto.getProviderType()));
        if (count >= 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public boolean isExistUser(UserSignInDto userSignInDto) {
        int count = userJpaRepository.countUserByPlatformIdAndPlatformType(userSignInDto.getProviderId(), PlatformType.valueOf(userSignInDto.getProviderType()));
        if (count >= 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Transactional
    public UserTokenDto SignUp(UserSignUpDto userSignUpDto) {

        User user = User.createUserFromDto(userSignUpDto);

        userJpaRepository.save(user);

        UserTokenDto userTokenDto = UserTokenDto.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getId().toString()))
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getId().toString()))
                .build();

        UserToken userToken = UserToken.createUserTokenFromDto(userTokenDto);

        userTokenJpaRepository.save(userToken);

        return userTokenDto;
    }

    public UserSignInResponse SignIn(UserSignInDto userSignInDto) {

        User user = userJpaRepository.findUserByPlatformIdAndpAndPlatformType(userSignInDto.getProviderId(), PlatformType.valueOf(userSignInDto.getProviderType())).get();
        UserToken token = userTokenJpaRepository.find

    }
}
