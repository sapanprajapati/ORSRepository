package com.bhagat.hritu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bhagat.hritu.dao.UserDAO;
import com.bhagat.hritu.dto.UserDTO;
import com.bhagat.hritu.exception.DuplicateUserException;

@Component
public class UserDAOImpl implements UserDAO{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO findByLogin(UserDTO user) {
        UserDTO userFound = userRepository.findByUserName(user.getUserName());
        if(null != userFound) {
           return userFound;
        }
        return null;
    }

    @Override
    public boolean createUser(UserDTO user) throws DuplicateUserException{
        UserDTO userExists = userRepository.findByUserName(user.getUserName());
        UserDTO userDto;
        if(null == userExists){
            userDto = userRepository.save(user);
        }else {
           throw new DuplicateUserException();
        }
        if(null != userDto){
            return true;
        }
        return false;
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return null;
    }
    
}
