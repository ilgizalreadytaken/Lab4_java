package n7;

import java.util.*;

public class ListCollector {

    // Метод для разделения чисел на положительные и отрицательные
    public static Map<String, List<Integer>> splitNumbersBySign(List<Integer> numbers) {
        // Создаем Map для хранения результатов
        Map<String, List<Integer>> result = new HashMap<>();

        // Списки для положительных и отрицательных чисел
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        // Перебираем все числа из списка
        for (Integer number : numbers) {
            // Если число положительное, добавляем его в список положительных
            if (number > 0) {
                positive.add(number);
                // Если число отрицательное, добавляем его в список отрицательных
            } else if (number < 0) {
                negative.add(number);
            }
        }

        // Сохраняем результаты в Map с ключами "positive" и "negative"
        result.put("positive", positive);
        result.put("negative", negative);

        // Возвращаем Map, содержащий разделенные числа
        return result;
    }

    // Метод для разделения строк на подсписки одинаковой длины
    public static List<List<String>> splitStringsByLength(List<String> strings) {
        // Создаем Map для хранения строк по длине
        Map<Integer, List<String>> lengthMap = new HashMap<>();

        // Перебираем все строки в списке
        for (String str : strings) {
            int length = str.length(); // Получаем длину строки

            // Если Map не содержит подсписка для данной длины, создаем его
            lengthMap.putIfAbsent(length, new ArrayList<>());

            // Добавляем строку в подсписок соответствующей длины
            lengthMap.get(length).add(str);
        }

        // Преобразуем Map в список подсписков
        return new ArrayList<>(lengthMap.values());
    }

    // Метод для получения уникальных строк
    public static Set<String> getUniqueStrings(List<String> strings) {
        // Используем HashSet для хранения уникальных строк (множество автоматически удаляет дубликаты)
        return new HashSet<>(strings);
    }
}
