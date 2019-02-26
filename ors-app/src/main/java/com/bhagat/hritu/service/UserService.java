package com.bhagat.hritu.service;

import com.bhagat.hritu.dto.UserDTO;
import com.bhagat.hritu.exception.DuplicateUserException;

public interface UserService {

    public UserDTO authenticateUser(UserDTO user);
    public boolean registerUser(UserDTO user) throws DuplicateUserException;
}
