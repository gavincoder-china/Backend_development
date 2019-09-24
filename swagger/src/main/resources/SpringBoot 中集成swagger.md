##  SpringBoot 中集成swagger

## 集成swagger-ui与Bootstrap-ui

## 导入Postman使用

### 1.添加依赖

```java
<!--        swagger依赖开始-->
<!--        主要依赖-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
<!--        官方ui-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.6.1</version>
        </dependency>
<!--        bootstrap-ui-->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>swagger-bootstrap-ui</artifactId>
            <version>1.9.3</version>
        </dependency>
<!--        swagger依赖结束-->
```



### 2.添加配置类

```java
@Configuration    
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfiguration {
    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Gavin_Swagger")
                .version("1.0")
                .build();
    }
}
```

### 3.在Controller中添加配置注解

> 在类上加注解
>
> > ```java
> > @Api(tags = "xx", produces = "xx")  //tags是分类标签,可以作为版本号区别
> > ```

> 在方法上加注解
>
> > ```java
> > @ApiOperation("展示")
> > @PostMapping(value = "/show")
> > //这边的形参,@valid的作用跟@requestBody一样,但方便参数在swagger中展示成列表形式(样式友好)
> > public User select(@Valid User user){
> > 
> >     return usersService.select();
> > }
> > ```

### 4.在实体类上加注解

> ```java
> @ApiModel
> @Data
> public class User {
>     private Integer uid;
>   
>   //这边是加在属性上的注解
>     @ApiModelProperty(value = "姓名",required = false)
>     private String username;
> 
>     private String password;
> 
>     private Integer gender;
> }
> ```
>
> 

### 5.访问路径

官方ui路径

> http://localhost:8080/swagger-ui.html
>
> ![image-20190923192600958](https://tva1.sinaimg.cn/large/006y8mN6gy1g79ob2z1lbj31em0ozwij.jpg)

bootstrap-ui路径

> http://localhost:8080/doc.html
>
> ![image-20190923192617230](https://tva1.sinaimg.cn/large/006y8mN6gy1g79obcmg8ej31eq0pf0wy.jpg)

### 6.整合进Postman

> 1.打开官方ui路径
>
> ![image-20190923192331816](https://tva1.sinaimg.cn/large/006y8mN6gy1g79o8j4q49j31550fsgr0.jpg)
>
> 2.打开postman,左上角点import
>
> ![image-20190923192435183](https://tva1.sinaimg.cn/large/006y8mN6gy1g79o9l091zj30wq0czjt0.jpg)
>
> 3.打开collections可以看到api的接口了
>
> ![image-20190923192529778](https://tva1.sinaimg.cn/large/006y8mN6gy1g79oaj7o13j31830ay406.jpg)

### 7.swagger注解详解

```java
swagger，指定swagger spec版本，2.0
info，提供API的元数据
tags，补充的元数据，在swagger ui中，用于作为api的分组标签
host，主机，如果没有提供，则使用文档所在的host
basePath，相对于host的路径
schemes，API的传输协议，http，https，ws，wss
consumes，API可以消费的MIME类型列表
produces，API产生的MIME类型列表
paths，API的路径，以及每个路径的HTTP方法，一个路径加上一个HTTP方法构成了一个操作。每个操作都有以下内容：
tags，操作的标签
summary，短摘要
description，描述
externalDocs，外部文档
operationId，标识操作的唯一字符串
consumes，MIME类型列表
produces，MIME类型列表
parameters，参数列表
responses，应答状态码和对于的消息的Schema
schemes，传输协议
deprecated，不推荐使用
security，安全
definitions，定义API消费或生产的数据类型，使用json-schema描述，操作的parameter和response部分可以通过引用的方式使用definitions部分定义的schema
parameters，多个操作共用的参数
responses，多个操作共用的响应
securityDefinitions，安全scheme定义
security，安全声明
externalDocs，附加的外部文档
```

