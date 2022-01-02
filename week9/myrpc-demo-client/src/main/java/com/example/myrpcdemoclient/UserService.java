package com.example.myrpcdemoclient;

import com.example.myrpc.client.MyRpcClient;

public interface UserService {

    User findById(int id);

}
