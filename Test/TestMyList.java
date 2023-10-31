import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.hw6.IMyList;
import seminars.hw6.MyIntList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestMyList {
    IMyList<Integer> list1;
    IMyList<Integer> list2;
    IMyList<Integer> list3;
    IMyList<Integer> list4;

    double firstAverage;
    double secondAverage;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        list1 = new MyIntList();
        list2 = new MyIntList();
        list3 = new MyIntList();
        list4 = new MyIntList();

        list1.setList(List.of(1,2,3,4,5,6));
        list2.setList(List.of(1,2,3,4,5,6));
        list3.setList(List.of(1,2,3,4,5,7));

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
    void testCompareIsEqual() {
        list1.compareAverage(list2);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Средние значения равны");
    }

    @Test
    void testCompareIsMore() {
        list3.compareAverage(list1);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Первый список имеет большее среднее значение");
    }

    @Test
    void testCompareIsLess() {
        list1.compareAverage(list3);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Второй список имеет большее среднее значение");
    }

    @Test
    void testCreateList() {
        list1.createList(10);
        assertThat(list1.getList().size()).isEqualTo(10);
    }



    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
