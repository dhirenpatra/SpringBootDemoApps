package org.dhiren.spring.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OrderBOImpl implements OrderBO{

    @Autowired
    @Qualifier("orderdao")
    private OrderDAO orderDAO;

    @Autowired
    @Qualifier("orderdao1")
    private OrderDAO orderDAO2;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void execute() {
        System.out.println("Executed And ...");
        orderDAO.save();
        orderDAO2.save();
    }
}
