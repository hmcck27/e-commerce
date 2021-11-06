package com.ecommerceapi.ecommerce.domain;

import com.ecommerceapi.ecommerce.dto.user.UserSignUpDto;
import com.ecommerceapi.ecommerce.enums.Agreement;
import com.ecommerceapi.ecommerce.enums.PlatformType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "platform_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private PlatformType platformType;

    @Column(name = "platform_id", nullable = false, updatable = false)
    private String platformId;

    @Column(name = "nickname", nullable = false, updatable = true)
    private String nickname;

    @Column(name = "email", nullable = false, updatable = false)
    private String email;

    @Column(name = "phone_number", nullable = false, updatable = false)
    private String phoneNumber;

    @Column(name = "markeing_agreement", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Agreement marketingAgreement;

    @Column(name = "service_agreement", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Agreement serviceAgreement;

    @Builder
    public User(PlatformType platformType, String platformId, String nickname, String email, String phoneNumber, Agreement marketingAgreement, Agreement serviceAgreement) {
        this.platformType = platformType;
        this.platformId = platformId;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.marketingAgreement = marketingAgreement;
        this.serviceAgreement = serviceAgreement;
    }

    public static User createUserFromDto(UserSignUpDto userSignInDto) {

        User newUser = User.builder()
                .platformType(PlatformType.valueOf(userSignInDto.getProviderType()))
                .platformId(userSignInDto.getProviderId())
                .nickname(userSignInDto.getName())
                .email(userSignInDto.getEmail())
                .phoneNumber(userSignInDto.getPhoneNumber())
                .marketingAgreement(Agreement.valueOf(userSignInDto.getMarketingAgreement()))
                .serviceAgreement(Agreement.valueOf(userSignInDto.getServiceAgreement()))
                .build();

        return newUser;
    }
}