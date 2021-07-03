package com.movenow.movenow.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> {
	
	
	List<UserCategory> findByUserId(Long userId);

}