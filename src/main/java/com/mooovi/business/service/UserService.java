package com.mooovi.business.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.mooovi.business.entity.User;

public interface UserService {
	 void save(User user);
	 
	 User findOne(Long id);
	 
	 User save(User user, MultipartFile file) throws IOException;
	 
	 byte[] downloadProfileImage(Long userId) throws IOException;


}
