package n5;

import java.util.List;
import java.util.ArrayList;


// Класс с методом filterList
public class ListFilter {
    // Фильтрация элементов списка по условию Predicate
    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item); // Добавляем только если условие true
            }
        }
        return result;
    }
}


/* Для каждого элемента списка вызывается метод test() интерфейса Predicate.
Если условие возвращает true, элемент добавляется в новый список.
Результатом работы метода является новый список, содержащий только те элементы, которые прошли фильтрацию.

 */