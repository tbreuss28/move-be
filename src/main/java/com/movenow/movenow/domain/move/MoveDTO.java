package com.movenow.movenow.domain.move;

import java.util.Date;

public class MoveDTO {

	private Long id;
	private String name;
	private String description;
	private Date startTime;
	private Date endTime;
	private Double latitude;
	private Double longitude;
	private Long categoryId;
	private String categoryName;
	private Long skillId;
	private String skillName;
	private Long creatorId;
	private Long mediaId;
	private String pictureUrl;
	private String videoUrl;
	private Double distanceFromUser;
	
	public MoveDTO() {
		
	}
	
	public MoveDTO(Move move) {
		this.id = move.getId();
		this.name =  move.getName();
		this.description =  move.getDescription();
		this.startTime =  move.getStartTime();
		this.endTime =  move.getEndTime();
		this.latitude =  move.getLatitude();
		this.longitude =  move.getLongitude();
		this.categoryId =  move.getCategoryId();
		this.skillId =  move.getSkillId();
		this.creatorId =  move.getCreatorId();
		this.mediaId =  move.getMediaId();
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Long getCreatorId()
	{
		return creatorId;
	}

	public void setCreatorId(Long creatorId)
	{
		this.creatorId = creatorId;
	}

	public Long getMediaId()
	{
		return mediaId;
	}

	public void setMediaId(Long mediaId)
	{
		this.mediaId = mediaId;
	}

	public String getPictureUrl()
	{
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl)
	{
		this.pictureUrl = pictureUrl;
	}

	public String getVideoUrl()
	{
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl)
	{
		this.videoUrl = videoUrl;
	}

	public Double getDistanceFromUser()
	{
		return distanceFromUser;
	}

	public void setDistanceFromUser(Double distanceFromUser)
	{
		this.distanceFromUser = distanceFromUser;
	}
}
