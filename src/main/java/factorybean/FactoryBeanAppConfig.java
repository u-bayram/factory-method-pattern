package factorybean;

import factorybean.samples.Student;
import factorybean.samples.StudentFactory;
import factorybean.samples.StudentNonSingletonFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: ubayram
 * Date: 18.01.2021
 * Time: 07:00
 */
@Configuration
public class FactoryBeanAppConfig {

    @Bean(name = "student")
    public StudentFactory studentFactory() {
        StudentFactory studentFactory = new StudentFactory();
        studentFactory.setId(1L);
        studentFactory.setName("Name");
        studentFactory.setSurname("Surname");
        return studentFactory;
    }

    @Bean
    public Student student() throws Exception {
        return studentFactory().getObject();
    }

    @Bean(name = "studentNonSingleton")
    public StudentNonSingletonFactory StudentNonSingletonFactory() {
        StudentNonSingletonFactory studentFactory = new StudentNonSingletonFactory();
        studentFactory.setId(2L);
        studentFactory.setName("Name 2");
        studentFactory.setSurname("Surname 2");
        return studentFactory;
    }

    @Bean
    public Student studentNonSingleton() throws Exception {
        return studentFactory().getObject();
    }

}
