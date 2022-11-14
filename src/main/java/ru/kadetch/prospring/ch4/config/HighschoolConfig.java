package ru.kadetch.prospring.ch4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.kadetch.prospring.ch4.FoodProviderService;
import ru.kadetch.prospring.ch4.highschool.FoodProviderServiceImpl;

@Configuration
@ComponentScan
@Profile("highschool")
public class HighschoolConfig {

    @Bean
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
