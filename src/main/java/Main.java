import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задание (введите цифру):\n1 калькулятор\n2 поиск максимального слова в массиве");
        String operation = scanner.next();
        switch (operation) {
            case "1" -> startCalculation(scanner);
            case "2" -> findMaxWordInArray(scanner);
            default -> System.err.println("Неизвестное задание!");
        }
        scanner.close();
    }

    private static void startCalculation(Scanner scanner) {
        Double result = chooseMathOperation(scanner);
        showResult(result);
    }

    private static void showResult(Double result) {
        if (result != null) {
            System.out.printf("Результат: %.4f", result);
        }
    }

    /**
     * Метод выбора и вызова математической операции
     *
     * @param scanner сканер для чтения из консоли
     * @return результат математической операции
     */
    private static Double chooseMathOperation(Scanner scanner) {
        System.out.println("Выберите операцию (введите цифру выбранной операции):\n1 сложение\n2 вычитание\n3 умножение\n4 деление");
        String operation = scanner.next();
        switch (operation) {
            case "1" -> {
                System.out.println("Введите 2 слагаемых через Enter, отделяйте дробную часть ЗАПЯТОЙ");
                Double firstSummand = scanner.nextDouble();
                Double secondSummand = scanner.nextDouble();
                return addition(firstSummand, secondSummand);
            }
            case "2" -> {
                System.out.println("Введите уменьшаемое и вычитаемое через Enter, отделяйте дробную часть ЗАПЯТОЙ");
                Double minuend = scanner.nextDouble();
                Double subtrahend = scanner.nextDouble();
                return subtraction(minuend, subtrahend);
            }
            case "3" -> {
                System.out.println("Введите 2 множителя через Enter, отделяйте дробную часть ЗАПЯТОЙ");
                Double firstMultiplier = scanner.nextDouble();
                Double secondMultiplier = scanner.nextDouble();
                return multiplication(firstMultiplier, secondMultiplier);
            }
            case "4" -> {
                System.out.println("Введите делимое и делитель2 через Enter, отделяйте дробную часть ЗАПЯТОЙ");
                Double dividend = scanner.nextDouble();
                Double divisor = scanner.nextDouble();
                if (divisor == 0) {
                    System.err.println("Делить на нуль нельзя!");
                } else {
                    return division(dividend, divisor);
                }
            }
            default -> System.err.println("Неизвестная операция!");
        }
        return null;
    }

    /**
     * Метод сложения 2х чисел с плавающей запятой
     *
     * @param firstSummand  первое слагаемое
     * @param secondSummand второе слагаемое
     * @return сумма
     */
    private static Double addition(Double firstSummand, Double secondSummand) {
        return firstSummand + secondSummand;
    }

    /**
     * Метод вычитания 2х чисел
     *
     * @param minuend    уменьшаемое
     * @param subtrahend вычитаемое
     * @return разность
     */
    private static Double subtraction(Double minuend, Double subtrahend) {
        return minuend - subtrahend;
    }

    /**
     * Метод умножения 2х чисел
     *
     * @param firstMultiplier  первый множитель
     * @param secondMultiplier сторой множитель
     * @return произведение
     */
    private static Double multiplication(Double firstMultiplier, Double secondMultiplier) {
        return firstMultiplier * secondMultiplier;
    }

    /**
     * Метод деления 2х чисел
     *
     * @param dividend делимое
     * @param divisor  делитель
     * @return частное
     */
    private static Double division(Double dividend, Double divisor) {
        return dividend / divisor;
    }

    /**
     * Метод для запуска поиска максимального слова в массиве
     *
     * @param scanner сканер для чтения из консоли
     */
    private static void findMaxWordInArray(Scanner scanner) {
        System.out.println("Введите размер массива (целое число):");
        int arrayCount = scanner.nextInt();
        if (arrayCount > 0) {
            ArrayList<String> words = readStrings(scanner, arrayCount);
            System.out.print("Введённый массив слов: ");
            printWordsArray(words);
            System.out.println();
            ArrayList<String> wordsWithMaxLenght = findLongestWord(words);
            System.out.print("Самое длинное слово(а) (" + wordsWithMaxLenght.get(0).length() + " символов):");
            printWordsArray(wordsWithMaxLenght);
        } else {
            System.out.println("Вы задали отрицательный или нулевой размер массива!");
        }
    }

    /**
     * Метод чтения массива строк из консоли
     *
     * @param scanner    сканер для чтения из консоли
     * @param arrayCount количество слов в массиве
     * @return считанный из консоли массив строк
     */
    private static ArrayList<String> readStrings(Scanner scanner, int arrayCount) {
        System.out.println("Введите " + arrayCount + " слов(а) через ENTER:");
        ArrayList<String> words = new ArrayList<>();
        while (words.size() < arrayCount) {
            String str = scanner.next();
            if (!words.contains(str)) {
                words.add(str);
            }
        }
        return words;
    }

    /**
     * Метод поиска самого длинного слова/слов, если есть несколько слов
     * одинаковой длинны с максимальным количеством символов
     *
     * @param words - массив слов из консоли
     * @return список слов с максимальным количеством символов
     */
    private static ArrayList<String> findLongestWord(ArrayList<String> words) {
        int maxLenght = 0;
        ArrayList<String> wordsWithMaxLenght = new ArrayList<>();
        for (String word : words) {
            if (word.length() > maxLenght) {
                maxLenght = word.length();
                wordsWithMaxLenght.clear();
                wordsWithMaxLenght.add(word);
            } else if (word.length() == maxLenght) {
                wordsWithMaxLenght.add(word);
            }
        }
        return wordsWithMaxLenght;
    }

    /**
     * Метод печати массива строк
     *
     * @param stringArrayForPrint массив строк, который нужно распечатать
     */
    private static void printWordsArray(ArrayList<String> stringArrayForPrint) {
        for (String word : stringArrayForPrint) {
            System.out.print(word + " ");
        }
    }
}