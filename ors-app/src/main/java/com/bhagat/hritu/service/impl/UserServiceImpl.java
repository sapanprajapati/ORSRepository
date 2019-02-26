package com.bhagat.hritu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagat.hritu.dao.UserDAO;
import com.bhagat.hritu.dto.UserDTO;
import com.bhagat.hritu.exception.DuplicateUserException;
import com.bhagat.hritu.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDao;
    
    @Override
    public UserDTO authenticateUser(UserDTO user) {
        return userDao.findByLogin(user);
    }

    @Override
    public boolean registerUser(UserDTO user) throws DuplicateUserException {
        return userDao.createUser(user);
    }

}
