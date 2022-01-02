package com.example.myrpcdemoclient;

import com.example.myrpc.client.MyRpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAop implements UserService{
    @Override
    @MyRpcClient(method = "findById",classStr = "com.example.myrpcdemoclient.UserService")
    public User findById(int id) {
        return null;
    }
}
