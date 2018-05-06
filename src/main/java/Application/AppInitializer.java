package Application;


import Models.Impl.InstanceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppInitializer {

    private static final Logger logger = LogManager.getLogger(AppInitializer.class);


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AppInitializer.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        InstanceImpl.getInstance().readFile(); //Считываем файл в структуру Instanceimpl

        //Здесь можно использовать любые доступные методы для работы со структурой приложения, доступные через InstanceImpl.getInstance()

        InstanceImpl.getInstance().saveInstanceToFile(); //записываем все данные из структуры в файл
    }
}