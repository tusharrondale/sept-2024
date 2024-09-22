package com.cdac.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.entity.Customer;
import com.cdac.entity2.ProfilePic;
import com.cdac.repository.CustomerRepo;

@Service
public class ProfilePicService {
 @Autowired
 private CustomerRepo custRepo;
	public int pic(ProfilePic profilePic) {
		try {
		Customer customer = new Customer();
		BeanUtils.copyProperties(profilePic, customer);
		
		//storing upload file
		try {
			
		MultipartFile mfile =	profilePic.getProfilePic();
		String fileName = mfile.getOriginalFilename();
		customer.setProfilePic(fileName);
		
		
		FileInputStream is = new FileInputStream(fileName);
		FileOutputStream os = new FileOutputStream("d:/uploads/"+fileName);
		FileCopyUtils.copy(is, os);
		
		Customer customer1 = custRepo.save(customer);
		int id = customer1.getId();
		return id;
		}catch (Exception e) {
			e.printStackTrace();
			return (Integer) null;
		}
		}catch (Exception e) {
		e.printStackTrace();
		return (Integer) null;
		}
	}
	
}
