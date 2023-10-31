/**
 * Пакет кода домашнего задания 6
 *
 * @author Maklashev Artem
 * @version 1.0
 */

package seminars.hw6;

import java.util.List;

/**
 * Интерфейс работы со списком
 *
 * @param <T> любой класс наследник Numeric
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public interface IMyList<T extends Number> {
    double countAverage();

    void compareAverage(IMyList<T> list2);

    void createList(int size);

    void setList(List<T> integers);

    List<T> getList();
}
