package com.ecommerceapi.ecommerce.repository;

import com.ecommerceapi.ecommerce.domain.User;
import com.ecommerceapi.ecommerce.enums.PlatformType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    int countUserByPlatformIdAndPlatformType(String platformId, PlatformType platformType);

    Optional<User> findUserByPlatformIdAndpAndPlatformType(String platformId, PlatformType platformType);

}
