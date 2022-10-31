package com.Luckystar.Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BookstoreApplication {
  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
  }

}
