package com.kate.annotation;

import com.kate.annotation.service.SurveyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.kate.annotation.domain.Student;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        SurveyService service = ctx.getBean(SurveyService.class);
        service.conductInterview(new Student());
    }
}
