package com.scaler.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SampleController {

    @GetMapping("/{name}/{number}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("number") int number) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=number; i++) {
            sb.append("Hello ").append(name).append("\n");
        }
        return sb.toString();
    }

}
