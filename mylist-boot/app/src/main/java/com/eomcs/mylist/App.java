package com.eomcs.mylist;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  // Spring 프레임워크(IoC = 객체풀)에서 객체를 생성한 후 보관하도록 만드는 방법
  @Bean 
  // => 스프링 부트를 시작할때 
  // => 이 메서드가 리턴한 값은 스프링 부트의 객체풀(object poll)에 보관한다.
  public DataSource createDataSource(
      @Value("${spring.datasource.driver-class-name}") String driverClassName, 
      @Value("${spring.datasource.url}") String url, 
      @Value("${spring.datasource.username}") String username, 
      @Value("${spring.datasource.password}") String password
      ) {
    try {
      DriverManagerDataSource connectionPool = new DriverManagerDataSource();
      connectionPool.setDriverClassName(driverClassName);
      connectionPool.setUrl(url);
      connectionPool.setUsername(username);
      connectionPool.setPassword(password);

      return connectionPool;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // Mybatis 객체 준비
  public SqlSessionFactory sqlSessionFactory(DataSource dataSoruce) throws Exception{
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

    // 1) SQL을 실행할 떄 사용할 DB 커넥션풀을 설정한다. 
    sqlSessionFactoryBean.setDataSource(dataSoruce);

    // 2) SQL 문이 들어 있는 파일의 위치를 설정한다. 
    PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
    sqlSessionFactoryBean.setMapperLocations(resourceResolver.getResources("classpath:com/eomcs/mylist/dao/*.xml"));

    return sqlSessionFactoryBean.getObject();
  }

  //@Bean
  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
    return args -> {

      System.out.println("빈 컨테이너가 생성한 객체(빈 컨테이너에 들어 있는 객체):");

      String[] beanNames = beanContainer.getBeanDefinitionNames();
      for (int i = 0; i < beanNames.length; i++) {
        Object bean = beanContainer.getBean(beanNames[i]);
        System.out.printf("----> %03d: %s\n", i + 1, bean.getClass().getName());
      }

    };
  }

  @RequestMapping("/hello")
  String hello() {
    return "Hello World!";
  }

}
