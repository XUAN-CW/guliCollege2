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

没有核心步骤，直接用就可以了

## 测试

 [DemoApplicationTests.java](code\src\test\java\com\example\demo\DemoApplicationTests.java) 

```java
    @Test
    public void testSelectQuery() {
        //创建QueryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //between
        //查询年龄 20-30
         wrapper.between("age",20,30);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }
```

剩下的用到再说： [wapper介绍.zip](references\wapper介绍.zip) 





