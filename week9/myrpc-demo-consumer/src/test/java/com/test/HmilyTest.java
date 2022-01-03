package com.test;

import com.example.myrpcdemoconsumer.HmilyService;
import com.example.myrpcdemoconsumer.MyrpcClientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyrpcClientApplication.class)
public class HmilyTest {

    @Autowired
    private HmilyService hmilyService;

    @Test
    public void  test1(){
        hmilyService.test();
    }
}
