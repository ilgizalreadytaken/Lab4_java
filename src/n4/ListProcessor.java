package n4;

import java.util.List;
import java.util.ArrayList;


/*

n4.ListProcessor содержит обобщенный метод processList, который принимает список типа T
и функцию function, преобразующую элементы списка из T в P.
Он обходит все элементы list, применяя к каждому из них function.apply(), и добавляет результат в список result.

Этот метод принимает:
список элементов, который нужно обработать
функцию — это кусочек логики, который применится к каждому элементу списка для его преобразования.

*/

public class ListProcessor {
    public static <T, P> List<P> processList(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}


/*Функция processList обобщает операции:
processList проходит по каждому элементу
списка и применяет к нему переданную функцию.
Полученные результаты собираются в новый список
*/