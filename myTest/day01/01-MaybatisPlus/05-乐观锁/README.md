# 乐观锁

## 主要适用场景

当要更新一条记录的时候，希望这条记录没有被别人更新，也就是说实现线程安全的数据更新

## 解决问题

脏读、幻读等

## 乐观锁实现方式

- 取出记录时，获取当前version
- 更新时，带上这个version
- 执行更新时， set version = newVersion where version = oldVersion
- 如果version不对，就更新失败

# 具体步骤

## 前置步骤

1. 准备数据库 [user.sql](data\user.sql) 
2. 创建 springboot 工程
3. 导入依赖 [pom.xml](code\pom.xml) 
4. 数据库连接配置 [application.properties](code\src\main\resources\application.properties) 
5. 编写实体类 [User.java](code\src\main\java\com\example\demo\entity\User.java) 
6. 编写 mapper  [UserMapper.java](code\src\main\java\com\example\demo\mapper\UserMapper.java) 
7. 扫描 mapper  [MpConfig.java](code\src\main\java\com\example\demo\config\MpConfig.java) 

## 核心步骤

### @Version

```java
@Version
private Integer version;//版本号
```

- 这一步是乐观锁的核心，请确保表中有 `version` 字段，名字无所谓，你叫 mybatisversion 也行，关键是要有一个标志，说明当前的版本
- 如果乐观锁时你后面添加的，记得修改插入操作代码，给 `version` 字段赋初值，使其不为 `null` ，否则会出现空指针异常或其他错误

### OptimisticLockerInterceptor

 [MpConfig.java](code\src\main\java\com\example\demo\config\MpConfig.java) 

```java
//乐观锁插件
@Bean
public OptimisticLockerInterceptor optimisticLockerInterceptor() {
    return new OptimisticLockerInterceptor();
}
```

## 测试

 [DemoApplicationTests.java](code\src\test\java\com\example\demo\DemoApplicationTests.java) 

```java
    /**
     * 测试 乐观锁插件
     * 测试后分析打印的sql语句，将version的数值进行了加1操作
     */
    @Test
    public void testOptimisticLocker() {
        //查询
        User user = userMapper.selectById(1);
        //修改数据
        user.setName("Helen Yao");
        user.setEmail("helen@qq.com");
        //执行更新
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁插件 失败
     */
    @Test
    public void testOptimisticLockerFail() {
        //查询
        User user = userMapper.selectById(1L);
        //修改数据
        user.setName("Helen Yao1");
        user.setEmail("helen@qq.com1");
        //模拟取出数据后，数据库中version实际数据比取出的值大，即已被其它线程修改并更新了version
        user.setVersion(user.getVersion() - 1);
        //执行更新
        userMapper.updateById(user);
    }
```

