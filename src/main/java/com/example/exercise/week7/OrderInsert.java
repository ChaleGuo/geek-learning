package com.example.exercise.week7;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 使用原生jdbc操作
 * 事务，批处理
 */
public class OrderInsert {
    @SneakyThrows
    public static void main(String[] args) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geek", "root", "root");

        con.setAutoCommit(false);
        //使用PreparedStatement
        System.out.println("preparedStatement batch insert start");
        long startTime = System.currentTimeMillis();
        String sql = "insert into my_order values (default,?,?,?,?,?,?,null,null,0,now(),now())";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        for (int i = 0; i < 1000000; i++) {
            preparedStatement.setLong(1, i);
            preparedStatement.setLong(2, i);
            preparedStatement.setInt(3, 1);
            preparedStatement.setLong(4, i);
            preparedStatement.setInt(5, i * 2);
            preparedStatement.setByte(6, (byte) 0);
            preparedStatement.addBatch();
        }

        int[] ints = preparedStatement.executeBatch();
        con.commit();
        System.out.println("insert all cost [" + (System.currentTimeMillis() - startTime) + "]ms");

        preparedStatement.close();
    }
}
