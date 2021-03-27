# 逻辑删除

- 物理删除：真实删除，将对应数据从数据库中删除，之后查询不到此条被删除数据
- 逻辑删除：假删除，将对应数据中代表是否被删除字段状态修改为“被删除状态”，之后在数据库中仍旧能看到此条数据记录

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

### @TableLogic

 [User.java](code\src\main\java\com\example\demo\entity\User.java) 

```java
    @TableLogic
    private Integer deleted;
```

- 这一步是逻辑删除的核心，请确保表中有 `deleted` 字段，名字无所谓，你叫 mybatisdeleted 也行，关键是要有一个标志，说明当前行是否被逻辑删除
- 注意：逻辑删除靠 `deleted` 字段判定，执行插入操作时记得设置 `deleted` 字段为未删除

### ISqlInjector

 [MpConfig.java](code\src\main\java\com\example\demo\config\MpConfig.java) 

```java
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
```

在配置类中配置逻辑删删除

## 测试

 [DemoApplicationTests.java](code\src\test\java\com\example\demo\DemoApplicationTests.java) 

```java
    /**
     * 测试 逻辑删除
     */
    @Test
    public void testLogicDelete() {

        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

    /**
     * 测试 逻辑删除后的查询：
     * 不包括被逻辑删除的记录
     */
    @Test
    public void testLogicDeleteSelect() {
        User user = new User();
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
```

逻辑删除后查询，查不到被逻辑删除的行

# 值的设置

mybatis-plus 默认  `1` 表示已经删除，`0` 表示未删除，你可以在  [application.properties](code\src\main\resources\application.properties)  中设置成其他值，但不建议

```properties
mybatis-plus.global-config.db-config.logic-delete-value=1
mybatis-plus.global-config.db-config.logic-not-delete-value=0
```



