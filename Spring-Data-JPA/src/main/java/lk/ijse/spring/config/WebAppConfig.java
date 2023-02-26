package lk.ijse.spring.config;

import lk.ijse.spring.Advicer.AppWideExceptionHandler;
import lk.ijse.spring.controller.CustomerController;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = {CustomerController.class, AppWideExceptionHandler.class})
@EnableWebMvc
public class WebAppConfig {}

//    @Bean
//    public ModelMapper modelMapper(){
//        return new ModelMapper();
//    }

