package my.spring.project.User.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
 	private int id;
  private String userName;
  private String password;
  private String userType;
  private String email;
  private String contact;
  private String confirmed;
  private String profileImage;
  public String getProfileImage() {
	return profileImage;
}


public void setProfileImage(String profileImage) {
	this.profileImage = profileImage;
}


@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", userType=" + userType
			+ ", email=" + email + ", contact=" + contact + ", confirmed=" + confirmed + ", profileImage="
			+ profileImage + "]";
}

 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 public String getUserName() {
		return userName;
	}


	public void setUserName(String username) {
		this.userName = username;
	}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getConfirmed() {
	return confirmed;
}
public void setConfirmed(String conformed) {
	this.confirmed = conformed;
}
}

