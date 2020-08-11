# springboot-datasoruce
使用druid动态切换多个数据源
1.在pom.xml加入dynamic-datasource-spring-boot-starter依赖
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
            <version>${dynamic.version}</version>
        </dependency>
2.修改application.yml配置文件，把之前单个数据源配置改成多个。
## druid连接池配置
spring:
    datasource:
        dynamic:
            #默认数据源
            primary: master
            datasource:
                # 主库配置 master
                master:
                    username: root
                    password: root
                    driver-class-name: com.mysql.cj.jdbc.Driver
                    url: jdbc:mysql://localhost:3306/learn_2020?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
                    initial-size: 1
                    max-active: 10
                    min-idle: 1
                    max-wait: 60000
                    pool-prepared-statements: true
                    max-pool-prepared-statement-per-connection-size: 5
                    time-between-eviction-runs-millis: 60000
                    min-evictable-idle-time-millis: 300000
                    #Oracle需要打开注释
                    #validation-query: SELECT 1 FROM DUAL
                    test-while-idle: true
                    test-on-borrow: false
                    test-on-return: false
                    stat-view-servlet:
                        enabled: true
                        url-pattern: /druid/*
                    filter:
                        stat:
                            log-slow-sql: true
                            slow-sql-millis: 1000
                            merge-sql: false
                        wall:
                            config:
                                multi-statement-allow: true
                # 从库配置 slave
                slave:
                    username: root
                    password: root
                    driver-class-name: com.mysql.cj.jdbc.Driver
                    url: jdbc:mysql://localhost:3306/learn_2020_1?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
                    initial-size: 1
                    max-active: 10
                    min-idle: 1
                    max-wait: 60000
                    pool-prepared-statements: true
                    max-pool-prepared-statement-per-connection-size: 5
                    time-between-eviction-runs-millis: 60000
                    min-evictable-idle-time-millis: 300000
                    #Oracle需要打开注释
                    #validation-query: SELECT 1 FROM DUAL
                    test-while-idle: true
                    test-on-borrow: false
                    test-on-return: false
                    stat-view-servlet:
                        enabled: true
                        url-pattern: /druid/*
                    filter:
                        stat:
                            log-slow-sql: true
                            slow-sql-millis: 1000
                            merge-sql: false
                        wall:
                            config:
                                multi-statement-allow: true
3.在代码中加入@DS("slave")就实现动态切换数据源了，不加的话就是默认的主数据源。
 @DS("slave")
    public SysUser queryById(Long id) {
        return this.sysUserDao.queryById(id);
    }
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }
4.更改spring boot启动类注解让他排除springboot默认加载的数据源，默认加载是直接从spring.datasource.druid下面开始找数据库连接信息。
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
