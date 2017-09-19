package com.lai.dao;

import com.lai.model.User;

/**
 * Created by lailai on 2017/9/18.
 */
public interface UserDao {

    void saveUser(User user);
    User findUserByUserName(String username);
    void updateUser(User user);
    void deleteUserById(Long id);
}
