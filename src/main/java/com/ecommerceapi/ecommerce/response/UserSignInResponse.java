package com.ecommerceapi.ecommerce.response;

import com.ecommerceapi.ecommerce.domain.User;
import com.ecommerceapi.ecommerce.domain.UserToken;
import lombok.Builder;
import lombok.Data;

@Data
public class UserSignInResponse {

    private String nickname;
    private String email;
    private String phoneNumber;
    private String accessToken;
    private String refreshToken;
    private String job;
    private String birth;

    @Builder
    public UserSignInResponse(String nickname, String email, String phoneNumber, String accessToken, String refreshToken, String job, String birth) {
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.job = job;
        this.birth = birth;
    }

    public static UserSignInResponse createResponseFromEntity(User user, UserToken token) {

        UserSignInResponse.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .phoneNumber(user.getp)

    }
}
