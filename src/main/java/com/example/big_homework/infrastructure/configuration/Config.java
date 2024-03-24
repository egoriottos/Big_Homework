package com.example.big_homework.infrastructure.configuration;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
