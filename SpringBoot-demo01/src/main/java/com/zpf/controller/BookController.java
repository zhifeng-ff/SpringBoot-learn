package com.zpf.controller;

import com.zpf.domain.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${lesson}")
    public String lesson;
    @Value("${server.port}")
    private Integer port;
    @Value("${enterprise.subject[0]}")
    private String subject;

    @Autowired
    private Environment environment;

    @Autowired
    private Enterprise enterprise;
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println("id==" + id);
        System.out.println(lesson);
        System.out.println(port);
        System.out.println(subject);
        System.out.println("----------------");
        System.out.println(environment.getProperty("lesson"));
        System.out.println(environment.getProperty("server.port"));
        System.out.println(environment.getProperty("enterprise.name"));
        System.out.println("----------------");
        System.out.println(enterprise.getName());
        System.out.println(enterprise);
        return  "springboot is running";
    }
}
