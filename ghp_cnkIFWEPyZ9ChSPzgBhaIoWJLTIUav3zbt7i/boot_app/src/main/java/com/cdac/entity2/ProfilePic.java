package com.cdac.entity2;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePic {
	
	private String name;
	private String city;
	private MultipartFile profilePic;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public MultipartFile getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}
	
	

}
