package com.movenow.movenow.domain.move;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "move")
public class Move {
	
	@Id
    @GeneratedValue
	private Long id;

	private String name;

	private String description;
	
	private Date startTime;
	
	private Date endTime;
	
	private Double latitude;

	private Double longitude;
	
	private Long categoryId;
	
	private Long skillId;
	


	public Move() {}

	public Move(String name, String description, Date startTime, Date endTime, double latitude, double longitude, Long categoryId, Long skillId) {
		this.name = name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.latitude = latitude;
		this.longitude = longitude;
		this.categoryId = categoryId;
		this.skillId = skillId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Move))
	      return false;
	    Move move = (Move) o;
	    return Objects.equals(this.id, move.id);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id);
	  }

	  @Override
	  public String toString() {
	    return "Move{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
	  }
}
	
	

