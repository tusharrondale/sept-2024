package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.RStatus;
//import com.cdac.dto.Status;
import com.cdac.entity2.ProfilePic;
import com.cdac.service.ProfilePicService;

@RestController
@CrossOrigin
public class ProfilePicController {
	@Autowired
	private ProfilePicService picServ;
	
	@PostMapping("/picData")
	public RStatus profile( @RequestBody ProfilePic profilepic) {
		
		int id =picServ.pic(profilepic);
		
		RStatus status = new RStatus();
		status.setStatusMessage("file uploaded..");
		status.setStatus(true);
		status.setCustomerId(id);
		return status;
	}

}
