package org.dhiren.spring;

import org.dhiren.spring.annotation.collections.Cart;
import org.dhiren.spring.annotation.models.Student;
import org.dhiren.spring.annotation.stereo.Instructor;
import org.dhiren.spring.interfaces.OrderBO;
import org.dhiren.spring.models.College;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext( new String[] {
                "college-config-constructor.xml","interfaces-config.xml"});
        ApplicationContext contextOne = new ClassPathXmlApplicationContext("student-config.xml");
        ApplicationContext contextTwo = new ClassPathXmlApplicationContext("cart-config.xml");
        ApplicationContext contextThree = new ClassPathXmlApplicationContext("instructor-config.xml");

        OrderBO bo = (OrderBO) context.getBean("orderbo");
        bo.execute();

        College college = (College) context.getBean("college");
        System.out.println("College Bean ==> " + college);

        College collegeOne = (College) context.getBean("collegeOne");
        System.out.println("College Bean ==> " + collegeOne);

        College collegeTwo = (College) context.getBean("collegeTwo");
        System.out.println("College Bean ==> " + collegeTwo);

        Student student = (Student) contextOne.getBean("student");
        System.out.println("Student Bean ==> " + student);

        Cart cart = (Cart) contextTwo.getBean("cart");
        System.out.println("Cart Bean ==> " + cart);

        Instructor instructor = (Instructor) contextThree.getBean("instructor");
        System.out.println("Instructor Bean ==> " + instructor);
        System.out.println("Instructor Bean hashcode ==> " + instructor.hashCode());

        Instructor instructor1 = (Instructor) contextThree.getBean("instructor");
        System.out.println("Instructor Bean ==> " + instructor1);
        System.out.println("Instructor Bean hashcode ==> " + instructor1.hashCode());
    }
}
