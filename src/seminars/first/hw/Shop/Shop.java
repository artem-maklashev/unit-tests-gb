package seminars.first.hw.Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        List<Product> sortedProducts = new ArrayList<>(products);
        if (!sortedProducts.isEmpty()) {
            sortedProducts.sort(Comparator.comparing(Product::getCost));
        }
        return sortedProducts;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        if (this.products.isEmpty()) {
            return null;
        }
        return this.products.stream().max(Comparator.comparing(Product::getCost)).get();
    }

    public String test() {
        return "Проверка";
    }
}