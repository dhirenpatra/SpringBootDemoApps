package org.dhiren.spring.interfaces;

public class OrderDAOImpl2 implements OrderDAO {

    @Override
    public void save() {
        System.out.println("Order saved Again");
    }
}
