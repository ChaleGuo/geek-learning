package com.example.exercise.week1;

import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    @SneakyThrows
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src\\main\\resources\\Hello.xlass");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            byte[] byteData = baos.toByteArray();
            for (int i = 0; i < byteData.length; i++) {
                byteData[i] = (byte) (255 - byteData[i]);
            }

            return defineClass(name, byteData, 0, byteData.length);
        } finally {
            try {
                fis.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @SneakyThrows
    public static void main(String[] args) {
        Class<?> clazz = new MyClassLoader().findClass("Hello");
        Method hello = clazz.getMethod("hello");
        hello.invoke(clazz.getDeclaredConstructor().newInstance());
        System.out.println("test1");
    }
}
