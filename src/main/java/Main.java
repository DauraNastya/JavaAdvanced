import calculation.PrimitiveCalculation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        System.out.println("Выберите операцию (введите цифру выбранной операции):\n1 сложение\n2 вычитание\n3 умножение\n4 деление");
        calculation.setOperation(scanner.next());
        System.out.println("Введите 2 числа через Enter, отделяйте дробную часть ЗАПЯТОЙ");
        calculation.setA(scanner.nextDouble());
        calculation.setB(scanner.nextDouble());
        calculation.calculate();
        calculation.showResult();
        scanner.close();
    }
}