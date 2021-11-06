package com.ecommerceapi.ecommerce.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
