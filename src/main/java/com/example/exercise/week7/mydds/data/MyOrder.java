package com.example.exercise.week7.mydds.data;

import lombok.Data;

import java.util.Date;

@Data
public class MyOrder {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer num;

    private Long addressId;

    private Integer amount;

    private Byte payType;

    private String expressCompany;

    private String trackingNumber;

    private Byte status;

    private Date insertTime;

    private Date updateTime;
}