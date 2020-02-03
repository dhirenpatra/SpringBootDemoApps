package org.dhiren.spring.service;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public int multiply(int n1, int n2) {
        System.err.println(n1 + " :: "+n2);
        return n1*n2;
    }

    @Override
    public double multiply(double n1, double n2) {
        return n1*n2;
    }
}
