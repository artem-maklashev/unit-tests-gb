package seminars.hw6;

import java.util.*;

public class MyIntList<Integer> implements IMyList {
    public static final Random RANDOM = new Random();
    private List<java.lang.Integer> list;

    public MyIntList() {
        this.list = new ArrayList<>();
    }


    @Override
    public double countAverage() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.stream().mapToInt(i -> i).average().getAsDouble();
    }



    @Override
    public void compareAverange(IMyList list2) {
        double firstAvrage = countAverage();
        double secondAvrage = list2.countAverage();
        if (firstAvrage == secondAvrage) {
            System.out.println("Средние значения равны");
        }
//        System.out.println(firstAvrage > secondAvrage ? "Первый список имеет большее среднее значение" : "Второй список имеет большее среднее значение");

    }

    public void createList(int size) {
        for (int i = 0; i < size; i++) {
            list.add(RANDOM.nextInt(10));
        }
    }

    public void setList(List<java.lang.Integer> list) {
        this.list = list;
    }

    public List<java.lang.Integer> getList() {
        return list;
    }
}
