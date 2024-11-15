package n3;

public class Point {
    // Поля для хранения координат X, Y и Z
    private final double x; // Координата X
    private final double y; // Координата Y
    private final Double z; // Координата Z (может быть null для 2D точек)

    // Конструктор для создания 3D точки с заданными координатами X, Y и Z
    public Point(double x, double y, double z) {
        this.x = x; // Инициализация координаты X
        this.y = y; // Инициализация координаты Y
        this.z = z; // Инициализация координаты Z
    }

    // Конструктор для создания 2D точки с заданными координатами X и Y
    public Point(double x, double y) {
        this(x, y, 0); // По умолчанию Z устанавливается в 0 для 2D точки
    }

    // Метод для получения текстового представления точки
    public String getRepresentation() {
        // Проверяем, существует ли координата Z и не равна ли она 0
        if (z != null && z != 0) {
            // Возвращаем строку с представлением 3D точки
            return "{" + x + ";" + y + ";" + z + "}";
        } else {
            // Возвращаем строку с представлением 2D точки
            return "{" + x + ";" + y + "}";
        }
    }
}