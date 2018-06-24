package com.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@SpringBootApplication
public class MyMockApplication {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        SpringApplication springApplication = new SpringApplication(MyMockApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
