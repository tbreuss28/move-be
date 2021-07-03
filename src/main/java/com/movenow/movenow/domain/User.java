package com.movenow.movenow.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;

@Entity(name="user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;
    
    private String lastName;
    
    private String userName;
    
    private ArrayList<Category> categories;

    public User() {}
    
    public User(String firstName, String lastName, String username) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.userName = username;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
    
    @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Move))
	      return false;
	    User user = (User) o;
	    return Objects.equals(this.id, user.id);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id);
	  }

	  @Override
	  public String toString() {
	    return "Move{" + "id=" + this.id + ", name='" + this.userName + '\'' + '}';
	  }
	
}
