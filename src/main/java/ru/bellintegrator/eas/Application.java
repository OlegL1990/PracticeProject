package ru.bellintegrator.eas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import ru.bellintegrator.eas.controller.EmployeeController;
import ru.bellintegrator.eas.controller.OfficeController;
import ru.bellintegrator.eas.controller.OrgController;
import ru.bellintegrator.eas.dao.impl.OfficeDAOImpl;
import ru.bellintegrator.eas.dao.impl.OrgDAOImpl;
import ru.bellintegrator.eas.dao.impl.EmployeeDAOImpl;
import ru.bellintegrator.eas.service.impl.EmployeeServiceImpl;
import ru.bellintegrator.eas.service.impl.OfficeServiceImpl;
import ru.bellintegrator.eas.service.impl.OrgServiceImpl;

import java.util.Locale;

@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
@ComponentScan(basePackageClasses = {OfficeDAOImpl.class, OrgDAOImpl.class, EmployeeDAOImpl.class, EmployeeServiceImpl.class, EmployeeController.class, OfficeServiceImpl.class, OfficeController.class, OrgController.class, OrgServiceImpl.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Bean
    public TaskExecutor controllerPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() + 1);
        executor.setQueueCapacity(25);
        return executor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }
}
