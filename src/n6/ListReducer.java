package n6;

import java.util.List;
import java.util.function.BiFunction;

public class ListReducer {

    // Метод для редуцирования списка в одно значение
    public static <T> T reduceList(List<T> list, BiFunction<T, T, T> accumulator, T identity) {
        T result = identity;  // Инициализация результата значением identity
        for (T item : list) {  // Проход по каждому элементу списка
            result = accumulator.apply(result, item);  // Применение операции сворачивания
        }
        return result;  // Возвращаем итоговое значение
    }

    // Перегрузка метода для работы с списком списков (подсчет элементов )
    public static int reduceListOfLists(List<List<Integer>> listOfLists) {
        int totalElements = 0;  // Инициализация счетчика элементов
        for (List<Integer> list : listOfLists) {  // Проход по спискам
            for (Integer item : list) {  // Проход по элементам каждого списка
                totalElements++;  // Увеличиваем счетчик для каждого элемента
            }
        }
        return totalElements;  // Возвращаем общее количество элементов
    }
}


/* В этой задаче не использовались интерфейсы, потому что
методы решают задачу, используя уже существующие функциональные
интерфейсы Java, такие как BiFunction (для сворачивания данных)
 и другие стандартные функциональные интерфейсы.
 */