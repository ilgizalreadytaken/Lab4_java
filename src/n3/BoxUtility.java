package n3;

public class BoxUtility {

    // Общий метод, который кладет трехмерную точку в коробку
    public static void putPointInBox(Box<?> box, double x, double y, double z) throws Exception {
        // Преобразуем коробку к n3.Box<n3.Point>, так как она может хранить только n3.Point
        if (box instanceof Box<?>) {
            // Проверяем, является ли коробка коробкой для объектов типа n3.Point
            Box<Point> pointBox = (Box<Point>) box;
            Point point = new Point(x, y, z); // Создаем точку с переданными координатами
            pointBox.put(point); // Кладем точку в коробку
        }
    }
}

/* в методе используется универсальный тип (wildcard) n3.Box<?>.
 Этот wildcard позволяет методу принимать коробки с любым типом параметризации,
 но при этом метод работает с конкретными типами внутри своей логики (например, n3.Box<n3.Point>).
 */