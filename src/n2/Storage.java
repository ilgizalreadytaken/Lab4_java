package n2;

// Класс Хранилище, которое может хранить один объект произвольного типа
public class Storage<T> {
    private final T item; // Хранимый объект, неизменяемое значение

    // Конструктор, который принимает объект для хранения
    public Storage(T item) {
        this.item = item;
    }

    // Метод get() всегда возвращает ссылку на объект (либо на объект в хранилище, либо на альтернативное значение).
    public T get() {
        if (item == null) {
            // Возвращаем альтернативное значение в случае, если объект равен null
            return getAlternativeValue();
        }
        return item; // Если объект не null, возвращаем его
    }

    // Метод, возвращающий альтернативное значение в зависимости от типа данных
    private T getAlternativeValue() {
        // Проверка типа данных с использованием instanceof
        if (item instanceof Integer) {
            return (T) Integer.valueOf(0); // Альтернатива для целых чисел: 0
        } else if (item instanceof String) {
            return (T) "default"; // Альтернатива для строк: "default"
        }
        return null; // Для других типов возвращаем null
    }
}
