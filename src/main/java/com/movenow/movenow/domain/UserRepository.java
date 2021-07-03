package com.movenow.movenow.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	List<User> findByIdIn(Collection<Long> ids);
}
