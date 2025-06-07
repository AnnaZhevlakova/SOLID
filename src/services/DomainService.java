package services;

import models.Basket;
import models.Product;
import models.ProductType;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class DomainService {
    private User user;
    private List<Product> products;
    private List<Basket> basket;

    public DomainService() {
        user = new User();
        user.setId(1);
        user.setLogin("test");
        products = new ArrayList<Product>();
        Product product = new Product();
        product.setId(1);
        product.setName("Lenovo");
        product.setPrise(999.9);
        product.setType(ProductType.Laptop);
        products.add(product);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("HP");
        product2.setPrise(300);
        product2.setType(ProductType.Laptop);
        products.add(product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("SAMSUNG");
        product3.setPrise(150);
        product3.setType(ProductType.Laptop);
        products.add(product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setName("Lenovo");
        product4.setPrise(999.9);
        product4.setType(ProductType.VacuumCleaner);
        products.add(product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setName("HP");
        product5.setPrise(300);
        product5.setType(ProductType.VacuumCleaner);
        products.add(product5);

        Product product6 = new Product();
        product6.setId(6);
        product6.setName("SAMSUNG");
        product6.setPrise(150);
        product6.setType(ProductType.VacuumCleaner);
        products.add(product6);

        Product product7 = new Product();
        product7.setId(7);
        product7.setName("HZ1");
        product7.setPrise(150);
        product7.setType(ProductType.Other);
        products.add(product7);

        Product product8 = new Product();
        product8.setId(8);
        product8.setName("HZ2");
        product8.setPrise(123);
        product8.setType(ProductType.Other);
        products.add(product8);

        Product product9 = new Product();
        product9.setId(9);
        product9.setName("HZ3");
        product9.setPrise(321);
        product9.setType(ProductType.Other);
        products.add(product9);

        Product product10 = new Product();
        product10.setId(10);
        product10.setName("HZ4");
        product10.setPrise(150);
        product10.setType(ProductType.Other);
        products.add(product10);

        basket = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Basket> getBasket() {
        return basket;
    }

    public User getUser() {
        return user;
    }

}
