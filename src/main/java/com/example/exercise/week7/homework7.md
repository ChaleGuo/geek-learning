1.order表插入100w数据测试

测试机器：i5，8核，32GB

1.1使用jdbc PreparedStatement batchinsert，AutoCommit为true，单线程一次性插入

```
preparedStatement batch insert start
insert all cost [664270]ms
```

1.2 使用jdbc PreparedStatement batchinsert，AutoCommit为true，单线程分段（一次10000）插入

```
insert all cost [656801]ms
```

1.3使用jdbc PreparedStatement batchinsert，AutoCommit为false，单线程一次性插入

```
insert all cost [89231]ms
```

1.4使用jdbc PreparedStatement batchinsert，AutoCommit为false，连接池+多线程一次性插入

```
insert all cost [20607]ms
```

