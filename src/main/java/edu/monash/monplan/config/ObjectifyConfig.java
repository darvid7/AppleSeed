package edu.monash.monplan.config;

import com.googlecode.objectify.ObjectifyService;
import edu.monash.monplan.model.Course;
import edu.monash.monplan.model.Unit;
import edu.monash.monplan.model.Transaction;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Arrays;

@Configuration
public class ObjectifyConfig implements ServletContextListener {

    @PostConstruct
    public void init() {
        registerObjectifyEntities();
    }

    private void registerObjectifyEntities() {
        register(Unit.class);
        register(Course.class);
        register(Transaction.class);
    }


    private void register(Class<?>... entityClasses) {
        Arrays.stream(entityClasses)
                .forEach(ObjectifyService::register);
    }
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        registerObjectifyEntities();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
