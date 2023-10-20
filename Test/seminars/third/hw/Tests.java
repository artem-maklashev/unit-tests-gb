package seminars.third.hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 18})
    void checkIsEvenTrue(int number){
        assertTrue(MainHW.evenOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7, 19})
    void checkIsEvenFalse(int number){
        assertFalse(MainHW.evenOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints =  {26, 99, 85, 50})
    void checkNumberIntervalTrue(int number){
        assertTrue(MainHW.numberInterval(number));
    }
    @ParameterizedTest
    @ValueSource(ints =  {1, 100, 25, -5})
    void checkNumberIntervalFalse(int number){
        assertFalse(MainHW.numberInterval(number));
    }

    @Test
    void checkLogout(){
        UserRepository ur = new UserRepository();
        User user1 = new User("Bob", "123", false);
        User user2 = new User("Tom", "123", true);
        user1.authenticate("Bob", "123");
        user2.authenticate("Tom", "123");
        ur.addUser(user1);
        ur.addUser(user2);

        ur.logout();

        assertThat(ur.getData().size()).isEqualTo(1);

    }


}
