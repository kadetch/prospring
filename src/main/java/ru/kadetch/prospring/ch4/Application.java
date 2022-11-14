package ru.kadetch.prospring.ch4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;
import ru.kadetch.prospring.ch4.config.HighschoolConfig;
import ru.kadetch.prospring.ch4.config.KindergartenConfig;

import java.util.Arrays;
import java.util.List;

@ComponentScan
public class Application {
    public static void main(String... args) throws Exception {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(KindergartenConfig.class, HighschoolConfig.class);
        System.out.println(Arrays.toString(ctx.getEnvironment().getActiveProfiles()));

        FoodProviderService foodProviderService = ctx.getBean("foodProviderService",
                FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }
        ctx.close();
    }

}
