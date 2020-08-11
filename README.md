# springboot-datasoruce
使用druid动态切换多个数据源
1.在pom.xml加入dynamic-datasource-spring-boot-starter依赖
2.修改application.yml配置文件，把之前单个数据源配置改成多个。
3.在代码中加入@DS("slave")就实现动态切换数据源了，不加的话就是默认的主数据源。
4.更改spring boot启动类注解让他排除springboot默认加载的数据源，默认加载是直接从spring.datasource.druid下面开始找数据库连接信息。
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
