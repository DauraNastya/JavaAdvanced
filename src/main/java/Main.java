import calculation.PrimitiveCalculation;
import exeptions.NullDividerException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        System.out.println("Выберите операцию (введите цифру выбранной операции):\n1 сложение\n2 вычитание\n3 умножение\n4 деление");
        calculation.setOperation(scanner.next());
        try {
            calculation.calculate();
            System.out.println("Введите 2 числа через Enter, отделяйте дробную часть ЗАПЯТОЙ");
            calculation.setA(scanner.nextDouble());
            calculation.setB(scanner.nextDouble());
        } catch (NullDividerException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Неизвестная операция!");
        }
        calculation.showResult();
        scanner.close();
    }
}