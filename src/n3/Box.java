package n3;

public class Box<T> {
    // параметр T — это тип данных, который подставляется
    // в момент создания экземпляра n3.Box. Таким образом, T становится конкретным
    // типом (например, Integer, String, и т.д.), который будет использоваться внутри методов этого класса.

    private T item;     // Поле private T item позволяет хранить один объект типа T,
                        // который указывается при создании экземпляра


    public boolean isEmpty() {          // Проверка, пуста ли коробкА
        return item == null;
    }

    public void put(T item) throws Exception {      // Метод для помещения объекта в коробку
        if (!isEmpty()) {                           // Если коробка не пуста, выбрасываем исключение
            throw new Exception("Коробка уже занята!");
        }
        this.item = item;
    }


    public T get() {                                // Метод для извлечения объекта из коробки
        T temp = item;                              // Сохраняем текущий объект для возврата
        item = null;                                // Обнуляем ссылку на объект после извлечения
        return temp;
    }


    @Override                                       // Переопределение toString() для вывода состояния коробки
    public String toString() {
        return isEmpty() ? "Коробка пуста" : "Коробка содержит: " + item;
    }
}