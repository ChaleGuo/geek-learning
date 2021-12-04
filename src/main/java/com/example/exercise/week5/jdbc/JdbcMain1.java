package com.example.exercise.week5.jdbc;

import lombok.SneakyThrows;

import java.sql.*;

/**
 * 使用原生jdbc操作
 */
public class JdbcMain1 {
    @SneakyThrows
    public static void main(String[] args) {
//        test1();
        test2();
    }

    /**
     * 原生jdbc Statement,PreparedStatement使用
     */
    @SneakyThrows
    private static void test1() {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geek", "root", "root");
        //使用Statement
//        Statement statement = con.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from student where id=4");

        //使用PreparedStatement
        PreparedStatement preparedStatement = con.prepareStatement("select * from student where id=?");
        preparedStatement.setInt(1, 3);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getInt("id"));
            System.out.println("name:" + resultSet.getString("name"));
            System.out.println("age:" + resultSet.getInt("age"));
            System.out.println("-----------------------------");
        }

        con.close();
//        statement.close();
        preparedStatement.close();
    }

    /**
     * Statement 手动commit 事务
     */
    @SneakyThrows
    private static void test2() {
        int i = 444;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geek", "root", "root");
        //不设置为false,第一条会执行成功
        con.setAutoCommit(false);

        Statement statement = con.createStatement();
        statement.executeUpdate(String.format("insert into student (name, age) values ('chale',%d)", i));
        if (true) {
            throw new RuntimeException("异常1");
        }
        statement.executeUpdate(String.format("insert into student (name, age) values ('chale',%d)", i + 1));
        con.commit();

        con.close();
        statement.close();
    }
}
