package com.testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyMockController {

    @GetMapping("/myMock")
    public String getMock() {
        return "From mock";
    }
}
