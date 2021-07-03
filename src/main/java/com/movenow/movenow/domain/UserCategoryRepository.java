package com.movenow.movenow.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> {

    List<UserCategory> findByUserId(Long userId);
}