package com.example.myrpc.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpcException extends RuntimeException {
    private int code;
    private String msg;
}
