package com.manage.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyProjectBeans {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
