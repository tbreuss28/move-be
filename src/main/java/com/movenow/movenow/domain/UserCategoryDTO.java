package com.movenow.movenow.domain;

public class UserCategoryDTO {
	
private Long id;
    
    private Long userId;
    private Long categoryId;
	private Long skillId;
	private String categoryName;
	private String skillName;
	
	
	public UserCategoryDTO(UserCategory userCategory) {
		this.userId = userCategory.getUserId();
		this.categoryId = userCategory.getCategoryId();
		this.skillId = userCategory.getSkillId();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}


}
