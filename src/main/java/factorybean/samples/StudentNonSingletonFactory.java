package factorybean.samples;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * User: ubayram
 * Date: 18.01.2021
 * Time: 07:27
 */
public class StudentNonSingletonFactory extends AbstractFactoryBean<Student> {

    private Long id;
    private String name;
    private String surname;

    public StudentNonSingletonFactory() {
        setSingleton(false);
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    protected Student createInstance() throws Exception {
        return new Student(id, name, surname);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
