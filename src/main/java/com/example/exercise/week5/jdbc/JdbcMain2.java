package com.example.exercise.week5.jdbc;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.Arrays;

/**
 * 使用原生jdbc操作
 * 事务，批处理
 */
public class JdbcMain2 {
    @SneakyThrows
    public static void main(String[] args) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geek", "root", "root");
        con.setAutoCommit(false);
        //使用statement
        /*Statement statement = con.createStatement();
        statement.addBatch("insert into student (name, age) values ('chale222',222)");
        statement.addBatch("insert into exam (subject, score) values ('yuwen',80)");
        int[] ints = statement.executeBatch();*/

        //使用PreparedStatement
        PreparedStatement preparedStatement = con.prepareStatement("insert into student (name, age) values (?,?)");
        for (int i = 0; i < 3; i++) {
            preparedStatement.setString(1, "name" + i);
            preparedStatement.setInt(2, 100 + i);
            preparedStatement.addBatch();
        }

        int[] ints = preparedStatement.executeBatch();
        //手动提交任务
        con.commit();
        for (int i : ints) {
            System.out.println(i);
        }

        con.close();
//        statement.close();
        preparedStatement.close();
    }
}
