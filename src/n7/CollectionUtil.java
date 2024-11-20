package n7;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class CollectionUtil {

    // Обобщенный метод для коллекционирования
    // T - тип элементов исходного списка
    // P - тип результирующей коллекции, которая должна быть наследником Collection<T>
    public static <T, P extends Collection<T>> P collect(
            List<T> sourceList,                // Исходный список элементов типа T
            Supplier<P> collectionFactory,     // Фабрика для создания экземпляра коллекции типа P
            Function<T, Boolean> filterFunction // Функция для фильтрации элементов из исходного списка
    ) {
        // Создание пустой коллекции с использованием фабрики
        P resultCollection = collectionFactory.get();

        // Перебор элементов исходного списка
        for (T item : sourceList) {
            // Применяем фильтрующую функцию к каждому элементу
            // Если элемент удовлетворяет условию, добавляем его в результирующую коллекцию
            if (filterFunction.apply(item)) {
                resultCollection.add(item);  // Добавление элемента в коллекцию
            }
        }

        // Возвращаем итоговую коллекцию с отфильтрованными элементами
        return resultCollection;
    }
}