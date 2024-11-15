import n2.Storage;
import n3.Box;
import n3.BoxUtility;
import n3.Point;
import n4.ListProcessor;
import n5.ListFilter;
import n6.ListReducer;
import n7.ListCollector;



import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays; // Этот импорт нужен для работы с Arrays.toString
import java.util.Map;
import java.util.Set;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false; // Флаг для выхода из программы

        List<Integer> numbersForTask1 = Arrays.asList(1, -3, 7);
        List<String> stringsForTask1 = Arrays.asList("qwerty", "asdfg", "zx", "qw");
        List<String> stringsForTask2 = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");

        while (!exit) {
            System.out.println("\nВыберите задание:");
            System.out.println("1 - Обобщенная коробка");
            System.out.println("2 - Хранилище");
            System.out.println("3 - Передача коробки с точкой");
            System.out.println("4 - Функция");
            System.out.println("5 - Фильтр");
            System.out.println("6 - Сокращение");
            System.out.println("7 - Коллекционирование");
            System.out.println("0 - Выход");
            System.out.println("Введите цифру задания: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Чистим буфер перед чтением следующей строки

            switch (choice) {
                case 1:
                    // Создание коробки, работа с ней
                    try {
                        Box<Integer> box = new Box<>(); // Создаем коробку для хранения целых чисел

                        System.out.print("Введите целое число для размещения в коробке: ");
                        int value = scanner.nextInt();

                        box.put(value); // Кладем значение в коробку
                        System.out.println(box); // Проверяем состояние коробки

                        // Извлекаем значение и выводим его
                        Integer extractedValue = box.get(); // Получаем значение из коробки
                        System.out.println("Извлеченное значение: " + extractedValue);

                        System.out.println(box); // Снова проверяем состояние коробки после извлечения

                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Вы выбрали кейс с хранилищем.");

                    // Создание хранилища с null для чисел
                    Storage<Integer> intStorageNull = new Storage<>(null);
                    System.out.println("Извлеченное значение из хранилища чисел (null): " + intStorageNull.get());

                    // Создание хранилища с 99 для чисел
                    Storage<Integer> intStorage99 = new Storage<>(99);
                    System.out.println("Извлеченное значение из хранилища чисел (99): " + intStorage99.get());

                    // Создание хранилища с null для строк
                    Storage<String> stringStorageNull = new Storage<>(null);
                    System.out.println("Извлеченное значение из хранилища строк (null): " + stringStorageNull.get());

                    // Создание хранилища с "hello" для строк
                    Storage<String> stringStorageHello = new Storage<>("hello");
                    System.out.println("Извлеченное значение из хранилища строк (hello): " + stringStorageHello.get());
                    break;

                case 3:
                    System.out.println("Вы выбрали кейс с передачей коробки с точкой.");

                    try {
                        // Создаем коробку для хранения объектов типа n3.Point
                        Box<Point> pointBox = new Box<>();

                        // Кладем трехмерную точку в коробку с произвольными координатами
                        BoxUtility.putPointInBox(pointBox, 5.0, 7.5, 3.0);

                        // Извлекаем точку из коробки и выводим её представление
                        Point point = pointBox.get();
                        System.out.println("Извлеченная точка: " + point.getRepresentation());

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    // Пример 1: Список строк и их длины
                    List<String> strings = List.of("qwerty", "asdfg", "zx");
                    List<Integer> stringLengths = ListProcessor.processList(strings, s -> s.length());

                    System.out.println("1. Список строк: " + strings);
                    System.out.println("Длины строк: " + stringLengths);

                    // Пример 2: Список чисел и их абсолютные значения
                    List<Integer> numbers = List.of(1, -3, 7);
                    List<Integer> absoluteNumbers = ListProcessor.processList(numbers, Math::abs);
                    System.out.println("2. Список чисел: " + numbers);
                    System.out.println("Абсолютные значения: " + absoluteNumbers);

                    // Пример 3: Запрос массивов целых чисел у пользователя
                    List<int[]> arrays = getArraysFromUser(scanner);  // Запрашиваем массивы у пользователя

                    if (arrays != null && !arrays.isEmpty()) {
                        List<Integer> maxValues = ListProcessor.processList(arrays, array -> {
                            int max = array[0];
                            for (int num : array) {
                                if (num > max) {
                                    max = num;
                                }
                            }
                            return max;
                        });
                        System.out.println("3. Максимальные значения: " + maxValues);
                    } else {
                        System.out.println("3. Вы не ввели массивы.");
                    }
                    break;

                case 5:
                    // Подзадание 1: Строки длиной >= 3
                    List<String> strings5 = List.of("qwerty", "asdfg", "zx");
                    List<String> filteredStrings = ListFilter.filterList(strings5, s -> s.length() >= 3);
                    System.out.println("1. Строки длиной >= 3: " + filteredStrings);

                    /*в метод filterList список строк и лямбда-выражение s -> s.length() >= 3,
                    которое является реализацией метода test для фильтрации строк длиной 3 и более символов. Лямбда-выражение позволяет кратко описать условие фильтрации.
                     */


                    // Подзадание 2: Отрицательные числа
                    List<Integer> numbers5 = List.of(1, -3, 7);
                    List<Integer> negativeNumbers = ListFilter.filterList(numbers5, n -> n < 0);
                    System.out.println("2. Отрицательные числа: " + negativeNumbers);

                    // Подзадание 3: Массивы без положительных чисел
                    List<int[]> arrays5 = getArraysFromUser(scanner);

                    if (arrays5 != null && !arrays5.isEmpty()) {
                        // Фильтрация массивов, не содержащих положительных чисел
                        List<int[]> filteredArrays = ListFilter.filterList(arrays5, array -> {
                            for (int num : array) {
                                if (num > 0) {
                                    return false; // Если есть положительное число, исключаем массив
                                }
                            }
                            return true; // Если нет положительных чисел, включаем массив
                        });

                        // Выводим отфильтрованные массивы
                        System.out.println("3. Массивы без положительных чисел:");
                        for (int[] array : filteredArrays) {
                            System.out.println(Arrays.toString(array));  // Используем Arrays.toString для правильного вывода массива
                        }
                    } else {
                        System.out.println("3. Вы не ввели массивы.");
                    }
                    break;

                case 6:

                    // Пример 1: Сформировать одну большую строку
                    List<String> strings6 = List.of("qwerty", "asdfg", "zx");
                    String concatenatedString = ListReducer.reduceList(strings6, (a, b) -> a + b, "");
                    System.out.println("1. Сформированная строка: " + concatenatedString);

                    // Пример 2: Сумма всех значений
                    List<Integer> numbers6 = List.of(1, -3, 7);
                    int sum = ListReducer.reduceList(numbers6, Integer::sum, 0);
                    System.out.println("2. Сумма всех значений: " + sum);

                    // Пример 3: Ввод данных вручную — список списков целых чисел
                    List<List<Integer>> listOfLists = new ArrayList<>();
                    int numLists = 0;

                    // Вводим количество списков с проверкой на некорректный ввод
                    while (true) {
                        System.out.println("Введите количество списков (целое положительное число):");
                        try {
                            numLists = Integer.parseInt(scanner.nextLine());
                            if (numLists <= 0) {
                                System.out.println("Количество списков должно быть положительным числом.");
                                continue;
                            }
                            break; // Выход из цикла, если ввод корректен
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка: введите целое число.");
                        }
                    }

                    // Вводим каждый список
                    for (int i = 0; i < numLists; i++) {
                        int numElements = 0;

                        // Вводим количество элементов в списке с проверкой на некорректный ввод
                        while (true) {
                            System.out.println("Введите количество элементов в списке " + (i + 1) + " (целое положительное число):");
                            try {
                                numElements = Integer.parseInt(scanner.nextLine());
                                if (numElements <= 0) {
                                    System.out.println("Количество элементов в списке должно быть положительным числом.");
                                    continue;
                                }
                                break; // Выход из цикла, если ввод корректен
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введите целое число.");
                            }
                        }

                        List<Integer> currentList = new ArrayList<>();

                        // Вводим элементы списка с проверкой на некорректный ввод
                        for (int j = 0; j < numElements; j++) {
                            while (true) {
                                System.out.println("Введите элемент " + (j + 1) + " списка " + (i + 1) + ":");
                                try {
                                    int element = Integer.parseInt(scanner.nextLine());
                                    currentList.add(element); // Добавляем элемент в список
                                    break; // Выход из цикла, если ввод корректен
                                } catch (NumberFormatException e) {
                                    System.out.println("Ошибка: введите целое число.");
                                }
                            }
                        }

                        listOfLists.add(currentList); // Добавляем текущий список в общий список
                    }

                    // Подсчитываем количество элементов во всех списках
                    int totalElements = ListReducer.reduceListOfLists(listOfLists);
                    System.out.println("3. Общее количество элементов во всех списках: " + totalElements);

                    break;

                case 7:

                    // Задание 1: Разделяем список чисел на положительные и отрицательные
                    System.out.println("1. Разделение чисел на положительные и отрицательные:");
                    // Вызов метода splitNumbersBySign, который принимает список чисел и возвращает Map, где
                    // ключами являются строки ("positive", "negative"), а значениями - списки чисел.
                    Map<String, List<Integer>> result1 = ListCollector.splitNumbersBySign(numbersForTask1);
                    // Результат для положительных чисел. Получаем список по ключу "positive".
                    System.out.println("Положительные: " + result1.get("positive"));
                    // Результат для отрицательных чисел. Получаем список по ключу "negative".
                    System.out.println("Отрицательные: " + result1.get("negative"));

                    // Задание 2: Разделение строк по длине
                    System.out.println("2. Разделение строк по длине:");
                    // Вызов метода splitStringsByLength, который принимает список строк и возвращает список,
                    // где каждая подсписок содержит строки одинаковой длины.
                    List<List<String>> result2 = ListCollector.splitStringsByLength(stringsForTask1);
                    // Выводим результат. Каждое подмножество в списке result2 содержит строки одной длины.
                    System.out.println(result2);

                    // Задание 3: Получение уникальных строк
                    System.out.println("3. Уникальные строки:");
                    // Вызов метода getUniqueStrings, который принимает список строк и возвращает Set,
                    // который гарантирует, что все строки будут уникальными (без повторений).
                    Set<String> result3 = ListCollector.getUniqueStrings(stringsForTask2);
                    // Выводим результат. result3 будет содержать только уникальные строки из исходного списка.
                    System.out.println(result3);

                    break;

                case 0:
                    exit = true; // Завершаем цикл, если выбрали выход
                    break;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }

        scanner.close();
    }

    // Метод для запроса массивов у пользователя
    public static List<int[]> getArraysFromUser(Scanner scanner) {
        System.out.println("Введите массивы целых чисел (каждый массив через запятую, массивы через пробел):");
        String input = scanner.nextLine(); // Чтение всей строки с массивами
        List<int[]> arrays = new ArrayList<>();

        // Если строка не пустая, начинаем разбирать введенные данные
        if (!input.isEmpty()) {
            String[] arrayStrings = input.split(" "); // Разделяем по пробелам (каждый массив)

            for (String arrayString : arrayStrings) {
                // Разделяем каждый массив по запятой и конвертируем элементы в числа
                String[] elements = arrayString.split(",");
                int[] array = new int[elements.length];

                for (int i = 0; i < elements.length; i++) {
                    try {
                        array[i] = Integer.parseInt(elements[i].trim()); // Парсим элементы
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный формат числа: " + elements[i]);
                        return null; // Возвращаем null в случае ошибки парсинга
                    }
                }
                arrays.add(array); // Добавляем массив в список
            }
        }

        return arrays.isEmpty() ? null : arrays; // Если не введено ни одного массива, возвращаем null
    }

}