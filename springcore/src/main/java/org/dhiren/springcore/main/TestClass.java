package org.dhiren.springcore.main;

import org.dhiren.springcore.contructor.models.College;
import org.dhiren.springcore.externalized.model.DBConfiguration;
import org.dhiren.springcore.innerBeans.MyCollege;
import org.dhiren.springcore.lifecycle.model.Patient;
import org.dhiren.springcore.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"config.xml", "patient-config.xml", "college-config.xml",
                        "college-config-constructor.xml", "db-config.xml"});
        getEmployees(context);
        getStudents(context);
        getHospitals(context);
        getDealers(context);
        getCustomers(context);
        getCoachingStudents(context);
        getPatients(context);
        getCollageInnerBean(context);
        getCollageConstructorInjection(context);
        getDatabaseProperties(context);
    }

    private static void getDatabaseProperties(ApplicationContext context) {
        DBConfiguration configuration = (DBConfiguration) context.getBean("mydao");
        System.out.println("DBConfiguration Bean Constructor Injection -->  " + configuration);
    }

    private static void getCollageConstructorInjection(ApplicationContext context) {
        College college = (College) context.getBean("college");
        College college_c = (College) context.getBean("college-c");
        System.out.println("College Bean Constructor Injection -->  " + college_c);
        System.out.println("College Bean Constructor Injection -->  " + college);
    }

    private static void getCollageInnerBean(ApplicationContext context) {
        MyCollege college = (MyCollege) context.getBean("mycollege");
        System.out.println("College Bean -->  " + college);
    }

    private static void getPatients(ApplicationContext context) {
        Patient patient = (Patient) context.getBean("patient");
        System.out.println("Patient Bean -->  " + patient.getId());
        AbstractApplicationContext applicationContext = (AbstractApplicationContext) context;
        applicationContext.registerShutdownHook();
    }

    private static void getCoachingStudents(ApplicationContext context) {
        CoachingStudents students1 = (CoachingStudents) context.getBean("coaching1");
        System.out.println("CoachingStudents Bean -->  " + students1.getScores());

        CoachingStudents students2 = (CoachingStudents) context.getBean("coaching2");
        System.out.println("CoachingStudents Bean -->  " + students2.getScores());

        CoachingStudents students3 = (CoachingStudents) context.getBean("coaching3");
        System.out.println("CoachingStudents Bean -->  " + students3.getScores());

        CoachingStudents students4 = (CoachingStudents) context.getBean("coaching4");
        System.out.println("CoachingStudents Bean -->  " + students4.getScores());
    }

    private static void getCustomers(ApplicationContext context) {
        Customer customer = (Customer) context.getBean("customer");
        System.out.println("Customer Bean -->  " + customer.getName() + " : " + customer.getProducts());
        System.err.println("Customer Bean Map type-->  " + customer.getProducts().getClass());
    }

    private static void getDealers(ApplicationContext context) {
        CarDealer carDealer = (CarDealer) context.getBean("car-dealer");
        System.out.println("CarDealer Bean -->  " + carDealer.getName() + " : " + carDealer.getModels());
        System.err.println("CarDealer Bean Set type-->  " + carDealer.getModels().getClass());
    }

    private static void getHospitals(ApplicationContext context) {
        Hospital hospital = (Hospital) context.getBean("hospital");
        System.out.println("Hospital Bean -->  " + hospital.getName() + " : " + hospital.getDepartments());
        System.err.println("Hospital Bean List type-->  " + hospital.getDepartments().getClass());
    }

    private static void getStudents(ApplicationContext context) {
        Student student = (Student) context.getBean("student");
        System.out.println("Student Bean -->  " + student.getId() + " : " + student.getName());
    }

    private static void getEmployees(ApplicationContext context) {
        Employee employee = (Employee) context.getBean("emp");
        System.out.println("Employee Bean --> " + employee.getId() + " : " + employee.getName());
    }
}
