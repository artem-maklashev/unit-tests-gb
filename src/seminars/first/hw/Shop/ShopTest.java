package seminars.first.hw.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        testGetMostExpensiveProductEmptyListReturnsNull();
        testGetMostExpensiveProductOneItemListReturnsProduct();
        testMostExpensiveProductMultipleItemsListReturnsCorrectProduct();
        testSortProductsByPriceEmptyListReturnsEmptyList();
        testSortProductsByPriceOneItemListReturnsSortedList();
        tedtSortProductsByPriceMultipleItemsListReturnsSortedList();
        testProductCount();
        testProductContent();
    }


    private static void testProductCount() {
        Shop shop = new Shop();
        List<Product> products = Arrays.asList(
                new Product(100, "Продукт 1"),
                new Product(200, "Продукт 2"),
                new Product(300, "Продукт 3")
        );
        shop.setProducts(products);
        assertThat(shop.getProducts().size()).isEqualTo(3);
    }
    private static void testProductContent() {
        Shop shop = new Shop();
        List<Product> products = Arrays.asList(
                new Product(100, "Продукт 1"),
                new Product(200, "Продукт 2"),
                new Product(300, "Продукт 3")
        );
        shop.setProducts(products);
        assertThat(shop.getProducts().get(0).getTitle()).isEqualTo("Продукт 1");
        assertThat(shop.getProducts().get(0).getCost()).isEqualTo(100);
        assertThat(shop.getProducts().get(1).getTitle()).isEqualTo("Продукт 2");
        assertThat(shop.getProducts().get(1).getCost()).isEqualTo(200);
        assertThat(shop.getProducts().get(2).getTitle()).isEqualTo("Продукт 3");
        assertThat(shop.getProducts().get(2).getCost()).isEqualTo(300);


    }


    public static void testGetMostExpensiveProductEmptyListReturnsNull() {
        Shop shop = new Shop();
        assertThatNullPointerException().isThrownBy(shop::getMostExpensiveProduct);
    }

    private static void testGetMostExpensiveProductOneItemListReturnsProduct() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        Product product = new Product(100, "Drink");
        products.add(product);
        shop.setProducts(products);
        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        assertThat(mostExpensiveProduct).isEqualTo(products.get(0));
    }

    private static void testMostExpensiveProductMultipleItemsListReturnsCorrectProduct() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(100, "Продукт 1"));
        products.add(new Product(200, "Продукт 2"));
        products.add(new Product(50, "Продукт 3"));
        shop.setProducts(products);

        Product mostExpensiveProduct = shop.getMostExpensiveProduct();

        assertThat(mostExpensiveProduct).isEqualTo(products.get(1));
    }

    private static void testSortProductsByPriceEmptyListReturnsEmptyList() {
        Shop shop = new Shop();
        shop.setProducts(new ArrayList<>());
        List<Product> sortedProducts = shop.sortProductsByPrice();

        assertThat(sortedProducts.size()).isEqualTo(0);
    }

    private static void testSortProductsByPriceOneItemListReturnsSortedList() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(100, "Продукт"));
        shop.setProducts(products);

        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertThat(sortedProducts).isEqualTo(products);
    }

    private static void tedtSortProductsByPriceMultipleItemsListReturnsSortedList() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(100, "Продукт 1"));
        products.add(new Product(200, "Продукт 2"));
        products.add(new Product(50, "Продукт 3"));
        shop.setProducts(products);

        List<Product> sortedProducts = shop.sortProductsByPrice();
//        for (Product p: sortedProducts
//             ) {
//            System.out.printf("Title: %s, cost: %s\n", p.getTitle(), p.getCost());
//
//        }
        assertThat(sortedProducts.get(0).getCost()).isEqualTo(products.get(2).getCost());
        assertThat(sortedProducts.get(1).getCost()).isEqualTo(products.get(0).getCost());
        assertThat(sortedProducts.get(2).getCost()).isEqualTo(products.get(1).getCost());

    }
}


