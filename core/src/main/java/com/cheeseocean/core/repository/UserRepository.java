package com.cheeseocean.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cheeseocean.core.entity.UserInfo;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {

    Optional<UserInfo> findByUsername(String username);

    Optional<UserInfo> findByEmail(String email);
}
