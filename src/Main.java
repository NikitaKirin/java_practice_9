import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


        // Запрос со сбором данных в коллекцию
        List<Integer> collectedList = new Random()
                .ints(1000, 10, 10000)
                .boxed()
                .toList();

        System.out.format("Коллекция: %s\n", collectedList);

        // Запрос на подсчет количества (например, простых чисел)
        long primeNumbersCount = new Random()
                .ints(1000, 10, 10000)
                .filter(x -> x > 1 && IntStream.range(2, x).noneMatch(i -> x % i == 0))
                .count();

        System.out.format("Количество простых чисел: %s\n", primeNumbersCount);

        // Запрос, где применяем редукцию множества значений к одному
        long sumOfNumbers = new Random()
                .ints(1000, 10, 10000)
                .sum();

        System.out.format("Сумма чисел: %s\n", sumOfNumbers);

        // Запрос на вывод в консоль
        new Random()
                .ints(1000, 10, 10000)
                .forEach(System.out::println);

        // Запрос с формированием результата в карту (число => квадрат числа)
        Map<Integer, Integer> resultMap = new Random()
                .ints(1000, 10, 10000)
                .boxed()
                .collect(Collectors.toMap(
                        number -> number,
                        number -> number * number,
                        Integer::max // Разрешаем коллизию ключей
                ));

        System.out.format("Карта: %s\n", resultMap);

        // Произвольная коллекция строк (городов)
        List<String> cities = Arrays.asList("Paris", "London", "New York", "Tokyo", "Berlin", "Rome");

        // Запрос 1: Вывести все города, начинающиеся с буквы "L"
        List<String> citiesStartingWithL = cities.stream()
                .filter(city -> city.startsWith("L"))
                .toList();
        System.out.println("Города с буквы 'L': " + citiesStartingWithL);

        // Запрос 2: Преобразовать все города в верхний регистр
        List<String> uppercaseCities = cities.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Города в верхнем регистре: " + uppercaseCities);

        // Запрос 3: Проверить, есть ли город с длиной имени больше 6 символов
        boolean anyCityWithLongName = cities.stream()
                .anyMatch(city -> city.length() > 6);
        System.out.println("Проверяем, есть ли город с длиной строки более 6 символов: " + anyCityWithLongName);

        // Запрос 4: Получить количество городов, содержащих букву "o"
        long countCitiesWithO = cities.stream()
                .filter(city -> city.contains("o"))
                .count();
        System.out.println("Количество городов, содержащих букву 'o': " + countCitiesWithO);

        // Запрос 5: Соединить названия городов в одну строку, разделяя запятой
        String concatenatedCities = String.join(", ", cities);
        System.out.println("Сконкатенированные города: " + concatenatedCities);
    }
}