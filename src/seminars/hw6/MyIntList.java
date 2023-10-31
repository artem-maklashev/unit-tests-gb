package seminars.hw6;

import java.util.*;

public class MyIntList implements IMyList<Integer> {
    public static final Random RANDOM = new Random();
    private List<java.lang.Integer> list;

    public MyIntList() {
        this.list = new LinkedList<>();
    }


    @Override
    public double countAverage() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.stream().mapToInt(i -> i).average().getAsDouble();
    }


    @Override
    public void compareAverage(IMyList<Integer> list2) {
        double firstAverage = countAverage();
        double secondAverage = list2.countAverage();
        if (firstAverage == secondAverage) {
            System.out.println("Средние значения равны");
        } else
            System.out.println(firstAverage > secondAverage ? "Первый список имеет большее среднее значение" : "Второй список имеет большее среднее значение");

    }

    @Override
    public void createList(int size) {
        if (!list.isEmpty()) {
            list = new LinkedList<>();
        }
        for (int i = 0; i < size; i++) {
            list.add(RANDOM.nextInt(10));
        }
    }

    @Override
    public void setList(List<java.lang.Integer> list) {
        this.list = list;
    }

    @Override
    public List<java.lang.Integer> getList() {
        return list;
    }
}
