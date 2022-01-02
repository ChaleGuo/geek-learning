package com.example.myrpcdemoclient;

import com.example.myrpc.client.MyRpcClient;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    @MyRpcClient(method = "findById")
    User findById(int id);

}
