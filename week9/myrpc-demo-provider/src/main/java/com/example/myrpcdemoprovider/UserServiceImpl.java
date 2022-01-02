package com.example.myrpcdemoprovider;


import com.example.myrpcdemoclient.User;
import com.example.myrpcdemoclient.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
