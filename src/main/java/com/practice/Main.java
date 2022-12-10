package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main (String[] args ){
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/greet")
    public GreetResponse greet(){
         GreetResponse response = new GreetResponse("Hello",
                List.of("Java","Python","SQL"),
                new Person("Alex", 25, 100_000));  //creates a json object
        return response;
    }

    record Person (String name, int age, double savings){}
    record GreetResponse(String greet,
                         List<String> ProgramingLanguages,
                         Person person){}
}
