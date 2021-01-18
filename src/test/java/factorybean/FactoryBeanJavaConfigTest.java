package factorybean;

import factorybean.samples.Student;
import factorybean.samples.StudentFactory;
import factorybean.samples.StudentNonSingletonFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * User: ubayram
 * Date: 18.01.2021
 * Time: 07:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FactoryBeanAppConfig.class)
public class FactoryBeanJavaConfigTest {

    @Autowired
    @Qualifier("student")
    private Student student;

    @Resource(name = "&student")
    private StudentFactory studentFactory;

    @Autowired
    @Qualifier("studentNonSingleton")
    private Student studentNonSingleton;

    @Resource(name = "&studentNonSingleton")
    private StudentNonSingletonFactory studentNonSingletonFactory;


    @Test
    public void testStudentFactory() {
        Assert.assertEquals(student.getId().toString(), String.valueOf(1L));
        Assert.assertEquals(student.getName(), "Name");
        Assert.assertEquals(student.getSurname(), "Surname");
    }

    @Test
    public void testStudentNonSingletonFactory() {
        Assert.assertEquals(studentNonSingleton.getId().toString(), String.valueOf(2L));
        Assert.assertEquals(studentNonSingleton.getName(), "Name 2");
        Assert.assertEquals(studentNonSingleton.getSurname(), "Surname 2");
    }

}