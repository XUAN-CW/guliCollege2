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

### PaginationInterceptor

 [MpConfig.java](code\src\main\java\com\example\demo\config\MpConfig.java) 

```java
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
```

## 测试

 [DemoApplicationTests.java](code\src\test\java\com\example\demo\DemoApplicationTests.java) 

```java
    //分页查询
    @Test
    public void testPage() {
        //1 创建page对象
        //传入两个参数：当前页 和 每页显示记录数
        Page<User> page = new Page<>(1,3);
        //调用mp分页查询的方法
        //调用mp分页查询过程中，底层封装
        //把分页所有数据封装到page对象里面
        userMapper.selectPage(page,null);

        //通过page对象获取分页数据
        System.out.println("当前页:"+page.getCurrent());
        System.out.println("每页数据list集合:"+page.getRecords());
        System.out.println("每页显示记录数:"+page.getSize());
        System.out.println("总记录数:"+page.getTotal());
        System.out.println("总页数:"+page.getPages());
        System.out.println("下一页:"+page.hasNext());
        System.out.println("上一页:"+page.hasPrevious());
    }
```

