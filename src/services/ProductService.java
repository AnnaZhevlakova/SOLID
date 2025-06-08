package services;

import Interfaces.IProductService;
import models.ProductBasket;
import models.Product;
import models.ProductFilter;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService {
    private DomainService domainService;

    public ProductService(DomainService domainService) {
        this.domainService = domainService;
    }

    public List<Product> getProducts(ProductFilter filter) {
        List<Product> result = domainService.getProducts();
        if (filter != null) {
            if (filter.getName() != null) {
                result = result.stream()
                        .filter(x -> x.getName().contains(filter.getName()))
                        .collect(Collectors.toList());
            } else if (filter.getMaxPrice() > 0) {
                result = result.stream()
                        .filter(x -> x.getPrise() <= filter.getMaxPrice())
                        .collect(Collectors.toList());
            }
        }
        return result;

    }

    public void clearBasket() {
        domainService.getBasket().clear();
    }

    public List<ProductBasket> getBasket() {
        List<ProductBasket> result = domainService.getBasket();
        return result;
    }

    public void putBasket(ProductBasket basket) throws Exception {
        List<ProductBasket> baskets = domainService.getBasket();
        ProductBasket element = baskets.stream()
                .filter(x -> x.getId() == basket.getId())
                .findFirst()
                .orElse(null);
        if (element == null) {
            Product product = domainService.getProducts().stream()
                    .filter(x -> x.getId() == basket.getId())
                    .findFirst()
                    .orElse(null);
            if (product == null) {
                throw new Exception("Такого товара нет!");
            }
            basket.setName(product.getName());
            basket.setPrise(product.getPrise());
            basket.setType(product.getType());
            baskets.add(basket);
        } else {
            element.setCount(element.getCount() + basket.getCount());
        }


    }

}
