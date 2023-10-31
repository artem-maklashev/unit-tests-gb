package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    //5.1.
    /*
    Создайте два модуля. Первый модуль генерирует список случайных чисел. Второй модуль находит
    максимальное число в этом списке.
    Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
    тест, который проверяет, что оба модуля работают вместе правильн
     */
    List<Integer> list;

    @BeforeEach
    void setUp() {
        list = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1);
    }

    @Test
    void testMaxNumberModule() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        int maxValue = maxNumberModule.getMaxValue(list);
        assertThat(maxValue).isEqualTo(5);
    }

    @Test
    void testRandomNumberModule() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        List<Integer> list = randomNumberModule.getList(10);

        assertThat(list.size()).isEqualTo(10);
    }

    @Test
    void testAll() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        RandomNumberModule randomNumberModule = new RandomNumberModule();

        list = randomNumberModule.getList(10);
        int maxValue = maxNumberModule.getMaxValue(list);

        assertThat(Collections.max(list)).isEqualTo(maxValue);
    }

    //5.2.
    /*
    У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для
    получения информации о пользователе. Ваша задача - написать интеграционный тест, который
    проверяет, что UserService и UserRepository работают вместе должным образом
     */
    @Test
    void testUserServiceAndRepository() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String userName = userService.getUserName(1);

        assertThat(userName).isEqualTo("User 1");
    }
    //5.3.
    //    У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и
    //    PaymentService. Класс OrderService обрабатывает заказы и делает вызовы к
    //    PaymentService для обработки платежей. Ваша задача - написать интеграционный тест,
    //    который проверяет, что OrderService и PaymentService взаимодействуют корректно
    @Test
    void testOderPaymentService() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService  = new OrderService(paymentService);

        boolean result = orderService.placeOrder("1", 10);
        assertTrue(result);
    }



}