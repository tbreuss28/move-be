package com.movenow.movenow.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MoveUser {
	
	
	@Id
    @GeneratedValue
    private long id;
    
    private long userId;
    private long moveId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getMoveId() {
		return moveId;
	}

	public void setMoveId(long moveId) {
		this.moveId = moveId;
	}

	

    
   
}
