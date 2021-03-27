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

### @TableField

 [User.java](code\src\main\java\com\example\demo\entity\User.java) 

```java
    //create_time
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //update_time
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
```

- @TableField

  - @TableField(fill = FieldFill.INSERT)

    INSERT时执行 MetaObjectHandler.insertFill(MetaObject metaObject)

  - @TableField(fill = FieldFill.INSERT_UPDATE)

    INSERT时执行 MetaObjectHandler.insertFill(MetaObject metaObject)

    UPDATE时执行updateFill(MetaObject metaObject)

### implements MetaObjectHandler

 [MyMetaObjectHandler.java](code\src\main\java\com\example\demo\handler\MyMetaObjectHandler.java) 

- 实现 MetaObjectHandler 对应的 insertFill、updateFill 等方法 
  - FieldFill.INSERT 对应 insertFill
  - FieldFill.INSERT_UPDATE 对应 insertFill 和 updateFill
- 添加 @Component 注解，交给 spring 管理即可

## 测试

 [DemoApplicationTests.java](code\src\test\java\com\example\demo\DemoApplicationTests.java) 

### insert

```java
    @Test
    public void insert() {
        User user = new User();
        userMapper.insert(user);
    }
```

查看数据库可见：create_time、update_time 被自动设置为当前时间

### update

```java
    @Test
    public void update() {
        User user = new User();
        user.setId((long) 1);
        userMapper.update(user,null);
    }
```

查看数据库可见：update_time 被自动设置为当前时间

