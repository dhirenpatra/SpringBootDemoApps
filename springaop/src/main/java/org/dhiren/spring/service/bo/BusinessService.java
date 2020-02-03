package org.dhiren.spring.service.bo;

import org.dhiren.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {

    @Autowired
    private ProductService productService;

    public int result(int n1, int n2) {
        return productService.multiply(n1,n2);
    }
}
