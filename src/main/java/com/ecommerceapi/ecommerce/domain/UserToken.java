package com.ecommerceapi.ecommerce.domain;

import com.ecommerceapi.ecommerce.dto.UserTokenDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user_token")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserToken extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private String id;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Builder
    private UserToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static UserToken createUserTokenFromDto(UserTokenDto userTokenDto) {

        UserToken userToken = UserToken.builder()
                .accessToken(userTokenDto.getAccessToken())
                .refreshToken(userTokenDto.getRefreshToken())
                .build();

        return userToken;
    }
}
