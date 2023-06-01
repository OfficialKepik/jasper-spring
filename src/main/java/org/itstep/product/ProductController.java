package org.itstep.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product", produces = "application/json")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping(value = "/products/sort", produces = "application/json")
    public List<Product> getProductsSort(@RequestParam(name = "property") String property) {
        return productService.orderBy(property);
    }
}
