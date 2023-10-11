package seminars.first.hw.Shop;

import java.util.ArrayList;
import java.util.List;

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
    }

    private static void testGetMostExpensiveProductOneItemListReturnsProduct() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        Product product  = new Product();
        product.setTitle("Drink");
        product.setCost(100);
        products.add(product);
        shop.setProducts(products);
        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        assertThat(mostExpensiveProduct).isEqualTo(products.get(0));
    }

    public static void testGetMostExpensiveProductEmptyListReturnsNull() {
        Shop shop = new Shop();
        assertThatNullPointerException().isThrownBy(shop::getMostExpensiveProduct);
    }





}

    @Test
    void getMostExpensiveProduct_multipleItemsList_returnsCorrectProduct() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(100, "Продукт 1"));
        products.add(new Product(200, "Продукт 2"));
        products.add(new Product(50, "Продукт 3"));
        shop.setProducts(products);

        Product mostExpensiveProduct = shop.getMostExpensiveProduct();

        assertEquals(products.get(1), mostExpensiveProduct);
    }

    @Test
    public void sortProductsByPrice_emptyList_returnsEmptyList() {
        Shop shop = new Shop();

        List<Product> sortedProducts = shop.sortProductsByPrice();

        assertEquals(0, sortedProducts.size());
    }

    @Test
    public void sortProductsByPrice_oneItemList_returnsSortedList() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(100, "Продукт"));
        shop.setProducts(products);

        List<Product> sortedProducts = shop.sortProductsByPrice();

        assertEquals(products, sortedProducts);
    }

    @Test
    public void sortProductsByPrice_multipleItemsList_returnsSortedList() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(100, "Продукт 1"));
        products.add(new Product(200, "Продукт 2"));
        products.add(new Product(50, "Продукт 3"));
        shop.setProducts(products);

        List<Product> sortedProducts = shop.sortProductsByPrice();

        assertEquals(products.get(2), sortedProducts.get(0));
        assertEquals(products.get(0), sortedProducts.get(1));
        assertEquals(products.get(1), sortedProducts.get(2));
    }