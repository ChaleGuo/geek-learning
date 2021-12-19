package com.example.exercise.week7.insert;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class OrderInsert3 {
    private static AtomicInteger ai = new AtomicInteger(0);
    static ExecutorService pool = new ThreadPoolExecutor(8, 8 * 2,
            5, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("insert-thread-%d").build());
    private static int poolSize = 10;

    @SneakyThrows
    public static void main(String[] args) {
        DataSource ds = getDs();
        System.out.println("async DataSource batch insert start");
        long startTime = System.currentTimeMillis();
        String sql = "insert into my_order values (default,?,?,?,?,?,?,null,null,0,now(),now())";
        CountDownLatch latch = new CountDownLatch(poolSize);
        for (int j = 0; j < poolSize; j++) {
            pool.execute(() -> {
                doinsert(ds, sql, latch);
            });
        }
        latch.await();
        System.out.println("insert all cost [" + (System.currentTimeMillis() - startTime) + "]ms");
        pool.shutdown();
    }

    private static DataSource getDs() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/geek");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", poolSize); // 最大连接数：10
        config.setAutoCommit(false);
        DataSource ds = new HikariDataSource(config);
        return ds;
    }

    @SneakyThrows
    private static void doinsert(DataSource ds, String sql, CountDownLatch latch) {
        long startTime = System.currentTimeMillis();
        Connection con = ds.getConnection();
        con.setAutoCommit(false);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        for (int i = 0; i < 100000; i++) {
            preparedStatement.setLong(1, i);
            preparedStatement.setLong(2, i);
            preparedStatement.setInt(3, 1);
            preparedStatement.setLong(4, i);
            preparedStatement.setInt(5, i * 2);
            preparedStatement.setByte(6, (byte) 0);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        con.commit();
        System.out.println(Thread.currentThread().getName() + ": insert cost [" + (System.currentTimeMillis() - startTime) + "]ms");
        latch.countDown();
    }
}
