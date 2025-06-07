import Interfaces.IProductService;
import models.Basket;
import models.Product;
import models.ProductFilter;
import services.DomainService;
import services.ProductService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        DomainService domainService = new DomainService();
        IProductService productService = new ProductService(domainService);
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Начало работы с программой");
            List<Product> allProducts = productService.getProducts(null);
            System.out.println(allProducts.toString());
            while (true) {
                System.out.println("1-получить весь список товара");
                System.out.println("2-показать содержимое корзины");
                System.out.println("3-очистить корзину");
                System.out.println("4-положить в корзину");
                System.out.println("0-выход из программы");

                System.out.print("Введите желаемое действие: ");
                int num = in.nextInt();

                if (num == Action.GetProducts.ordinal()) {
                    in.nextLine();
                    System.out.println("Использовать фильтр? Y/N");
                    String l = in.nextLine();
                    l = l.toUpperCase(Locale.ROOT);
                    if (l.equals("Y") || l.equals("Н")) {
                        System.out.println("Введите максимальную цену товара: ");
                        float price = in.nextFloat();
                        var filter = new ProductFilter();
                        filter.setMaxPrice(price);
                        allProducts = productService.getProducts(filter);

                    } else {
                        allProducts = productService.getProducts(null);

                    }
                    System.out.println(allProducts.toString());


                } else if (num == Action.GetBasket.ordinal()) {
                    productService.getBasket();

                } else if (num == Action.ClearBasket.ordinal()) {
                    productService.clearBasket();

                } else if (num == Action.Exit.ordinal()) {
                    break;

                } else if (num == Action.PutBasket.ordinal()) {
                    System.out.print("Выберите номер продукта: ");
                    num = in.nextInt();
                    System.out.print("Введите кол-во товара: ");
                    int count = in.nextInt();
                    Basket basket = new Basket();
                    basket.setId(num);
                    basket.setCount(count);
                    productService.putBasket(basket);
                    List<Basket> result = productService.getBasket();
                    System.out.println(result.toString());
                    double totalAmount = result.stream()
                            .mapToDouble(x -> x.getTotalPrice())
                            .sum();
                    System.out.println("Общая сумма покупки:" + totalAmount);

                }

            }

        } finally {
            System.out.println("Завершение программы.");
        }
    }
}