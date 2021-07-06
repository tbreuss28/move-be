package com.movenow.movenow.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

	
public interface MoveUsersRepository extends JpaRepository<MoveUser, Long> {
	List<MoveUser> findByMoveId(Long moveId);

	List<MoveUser> findByMoveIdAndUserId(Long moveId, Long userId);
}

