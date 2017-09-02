package com.mooovi.business.service;

import com.mooovi.business.entity.User;

public interface UserService {

    void save(User user);
    
    User findOne(Long id);

}