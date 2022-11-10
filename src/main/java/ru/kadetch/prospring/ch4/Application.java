package ru.kadetch.prospring.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Application {
    public static void main(String... args) throws Exception {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("highschool");
        ctx.load("classpath:spring/*-config.xml");
        ctx.refresh();

        FoodProviderService foodProviderService = ctx.getBean("foodProviderService",
                FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }
        ctx.close();
    }

}
