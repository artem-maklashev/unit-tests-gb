
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.hw6.MyIntList;
import seminars.hw6.Service;
import static org.mockito.Mockito.*;

public class TestService {
    MyIntList myList;
    MyIntList myList2;
    Service service;
    @BeforeEach
    void setUp() {
        myList = mock(MyIntList.class);
        myList2 = mock(MyIntList.class);
        service = new Service(myList);
    }

    @Test
    void testCreateList() {
        service.createList(10);

        verify(myList, times(1)).createList(10);
    }

    @Test
    void testCompareList() {
        service.compareAverage(myList2);

        verify(myList, times(1)).compareAverage(myList2);

    }

}
