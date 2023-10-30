package seminars.hw6;

import java.util.List;

public interface IMyList <T extends Number>{
    double countAverage();
    void compareAverange(IMyList<T> list2);

}
