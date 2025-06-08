package Interfaces;

import models.ProductBasket;
import models.Product;
import models.ProductFilter;

import java.util.List;

public interface IProductService {
    List<Product> getProducts(ProductFilter filter);

    void clearBasket();

    List<ProductBasket> getBasket();

    void putBasket(ProductBasket basket) throws Exception;

}
