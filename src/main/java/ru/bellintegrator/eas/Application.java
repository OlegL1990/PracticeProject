package ru.bellintegrator.eas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.bellintegrator.eas.dao.impl.OfficeDAOImpl;
import ru.bellintegrator.eas.dao.impl.OrgDAOImpl;
import ru.bellintegrator.eas.dao.impl.EmployeeDAOImpl;
import ru.bellintegrator.eas.service.impl.EmployeeServiceImpl;

@SpringBootApplication
@ComponentScan(basePackageClasses = {OfficeDAOImpl.class, OrgDAOImpl.class, EmployeeDAOImpl.class, EmployeeServiceImpl.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
