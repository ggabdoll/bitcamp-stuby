package com.eomcs.mylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  //  @Bean
  //  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
  //    return args -> {
  //
  //      System.out.println("Bean Container가 생성한 Object(Bean Container에 들어있은 Object)");
  //
  //      String[] beanNames = beanContainer.getBeanDefinitionNames();
  //      Arrays.sort(beanNames);
  //      for (int i = 0; i < beanNames.length; i++) {
  //        Object bean = beanContainer.getBean(beanNames[i]);
  //        System.out.printf("---->%03d: %s\n", i+1, bean.getClass().getName());
  //      }
  //
  //    };
  //  }

  @RequestMapping("/hello")
  String hello() {
    return "Hello World!";
  }

}
