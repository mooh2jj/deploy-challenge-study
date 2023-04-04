package com.example.learndocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnDockerController {

    @GetMapping("/test")
    public String test(String test){
        return test+" HIHI DOCKER";
    }
}
