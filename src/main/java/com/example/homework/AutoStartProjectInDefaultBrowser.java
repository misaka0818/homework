package com.example.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;


@SpringBootConfiguration
public class AutoStartProjectInDefaultBrowser implements CommandLineRunner {
    @Override
    public void run(String ... args) throws Exception {
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:8080/login.html");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
