###题目2：order表插入100w数据测试

测试机器：i5，8核，32GB
代码：同级目录./insert

1.使用jdbc PreparedStatement batchinsert，AutoCommit为true，单线程一次性插入

```
preparedStatement batch insert start
insert all cost [664270]ms
```

2.使用jdbc PreparedStatement batchinsert，AutoCommit为true，单线程分段（一次10000）插入

```
insert all cost [656801]ms
```

3.使用jdbc PreparedStatement batchinsert，AutoCommit为false，单线程一次性插入

```
insert all cost [89231]ms
```

4.使用jdbc PreparedStatement batchinsert，AutoCommit为false，连接池+多线程一次性插入

```
insert all cost [20607]ms
```
###题目9：读写分离 - 动态切换数据源版本 1.0
代码：同级目录./mydds

###题目10：读写分离 - 数据库框架版本 2.0
代码：同级目录./shardingshpere



