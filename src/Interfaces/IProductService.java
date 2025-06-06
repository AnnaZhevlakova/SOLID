package Interfaces;

import models.Basket;
import models.Product;
import models.ProductFilter;

import java.util.List;

public interface IProductService {
    List<Product> getProducts(ProductFilter filter);

    void clearBasket();

    List<Basket> getBasket();

    List<Basket> putBasket(Basket basket) throws Exception;

}
