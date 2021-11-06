package com.ecommerceapi.ecommerce.repository;

import com.ecommerceapi.ecommerce.domain.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTokenJpaRepository extends JpaRepository<UserToken, Long> {


}
