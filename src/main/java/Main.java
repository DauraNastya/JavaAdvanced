import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите операцию (введите цифру выбранной операции):\n1 сложение\n2 вычитание\n3 умножение\n4 деление");
        String operation = scanner.next();
        Double result = chooseOperation(scanner, operation);
        if (result != null) {
            System.out.printf("Результат: %.4f", result);
        }
        scanner.close();
    }

    /**
     * Метод выбора и вызова математической операции
     *
     * @param scanner   сканер для чтения из консоли
     * @param operation номер выбранной операции
     * @return результат математической операции
     */
    private static Double chooseOperation(Scanner scanner, String operation) {
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
}