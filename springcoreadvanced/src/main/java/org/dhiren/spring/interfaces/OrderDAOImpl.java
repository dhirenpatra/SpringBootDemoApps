package org.dhiren.spring.interfaces;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public void save() {
        System.out.println("Order saved");
    }
}
