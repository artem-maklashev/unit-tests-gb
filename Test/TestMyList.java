import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.hw6.MyIntList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestMyList {
    MyIntList<Integer> list1;
    MyIntList<Integer> list2;
    MyIntList<Integer> list3;
    MyIntList<Integer> list4;

    double firstAverage;
    double secondAverage;

    @BeforeEach
    void setUp() {
        list1 = new MyIntList<>();
        list2 = new MyIntList<>();
        list3 = new MyIntList<>();
        list4 = new MyIntList<>();

        list1.setList(Arrays.asList(1,2,3,4,5,6));
        list2.setList(Arrays.asList(1,2,3,4,5,6));
        list3.setList(Arrays.asList(1,2,3,4,5,7));

        firstAverage = 2.5;
        secondAverage = 2.0;
    }

    @Test
    void testAverageResult() {
        assertThat(list1.countAverage()).isEqualTo(3.5);
    }

    @Test
    void testResultIfEmptyList() {
        assertThatThrownBy(() -> list4.countAverage())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void testCompare() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        list1.compareAverange(list2);

        assertThat(result).isEqualTo("Средние значения равны");
    }

}
