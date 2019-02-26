package com.bhagat.hritu.dao;

import com.bhagat.hritu.dto.UserDTO;
import com.bhagat.hritu.exception.DuplicateUserException;

public interface UserDAO {
   public UserDTO findByLogin(UserDTO user);
   public boolean createUser(UserDTO user) throws DuplicateUserException;
   public UserDTO updateUser(UserDTO user);
}
