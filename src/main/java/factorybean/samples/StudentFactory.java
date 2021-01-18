package factorybean.samples;

import org.springframework.beans.factory.FactoryBean;

/**
 * User: ubayram
 * Date: 18.01.2021
 * Time: 06:33
 */
public class StudentFactory implements FactoryBean<Student> {

    private Long id;
    private String name;
    private String surname;

    @Override
    public Student getObject() throws Exception {
        return new Student(id, name, surname);
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
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
