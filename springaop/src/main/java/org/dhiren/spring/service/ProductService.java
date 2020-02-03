package org.dhiren.spring.service;

import org.springframework.stereotype.Component;

@Component
public interface ProductService {
    int multiply(int n1, int n2);
    double multiply(double n1, double n2);
}
