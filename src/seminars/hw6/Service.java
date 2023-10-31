package seminars.hw6;

import java.util.List;

public class Service {
    private final MyIntList myList;

    public Service(MyIntList myList) {
        this.myList = myList;
    }

    public void createList(int size) {
        myList.createList(size);
    }

    public void compareAverage(MyIntList myList2) {
        myList.compareAverage(myList2);
    }
}
