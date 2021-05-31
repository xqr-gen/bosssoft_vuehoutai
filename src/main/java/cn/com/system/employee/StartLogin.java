package cn.com.system.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.com.system.employee.controller",
                               "cn.com.system.employee.service",
                               "cn.com.system.employee.config"})
public class StartLogin {
    public static void main(String[] args){
        SpringApplication.run(StartLogin.class,args);
    }
}
