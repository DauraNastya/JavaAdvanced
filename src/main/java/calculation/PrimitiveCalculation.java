package calculation;

import exeptions.NullDividerException;

public class PrimitiveCalculation extends CommonCalculation {
    private Double result;

    public PrimitiveCalculation() {
    }

    public PrimitiveCalculation(double a, double b, String operation) {
        super(a, b, operation);
    }

    public void calculate() throws NullDividerException {
        switch (this.getOperation()) {
            case "1" -> addition(a, b);
            case "2" -> subtraction(a, b);
            case "3" -> multiplication(a, b);
            case "4" -> division(a, b);
            default -> System.err.println("Неизвестная операция!");
        }
    }

    public void showResult() {
        if (this.result != null) {
            System.out.printf("Результат: %.4f", result);
        }
    }

    /**
     * Метод сложения 2х чисел с плавающей запятой
     *
     * @param firstSummand  первое слагаемое
     * @param secondSummand второе слагаемое
     */
    private void addition(double firstSummand, double secondSummand) {
        this.result = firstSummand + secondSummand;
    }

    /**
     * Метод вычитания 2х чисел
     *
     * @param minuend    уменьшаемое
     * @param subtrahend вычитаемое
     */
    private void subtraction(double minuend, double subtrahend) {
        this.result = minuend - subtrahend;
    }

    /**
     * Метод умножения 2х чисел
     *
     * @param firstMultiplier  первый множитель
     * @param secondMultiplier сторой множитель
     */
    private void multiplication(double firstMultiplier, double secondMultiplier) {
        this.result = firstMultiplier * secondMultiplier;
    }

    /**
     * Метод деления 2х чисел
     *
     * @param dividend делимое
     * @param divisor  делитель
     * @throws NullDividerException - выброс исключения при делителе равном нулю.
     */
    private void division(double dividend, double divisor) throws NullDividerException {
        if (divisor == 0) {
            throw new NullDividerException("Divider is NULL!");
        } else {
            this.result = dividend / divisor;
        }
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
