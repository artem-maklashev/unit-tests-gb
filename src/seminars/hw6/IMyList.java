package seminars.hw6;

import java.util.Collection;
import java.util.List;

public interface IMyList <T extends Number>{
    double countAverage();
    void compareAverage(IMyList<T> list2);
    void createList(int size);

    void setList(List<T> integers);

    List<T> getList();
}
