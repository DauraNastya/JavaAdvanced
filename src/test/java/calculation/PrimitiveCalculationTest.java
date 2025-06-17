package calculation;

import exeptions.NullDividerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitiveCalculationTest {
    @Test
    public void addition() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.addition(0.0, 1.1);
        Assertions.assertEquals(1.1, calculation.getResult(), "Addition with 0");
    }

    @Test
    public void additionWithNegative() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.addition(-5.0, 1.1);
        Assertions.assertEquals(-3.9, calculation.getResult(), "Addition with negative");
    }

    @Test
    public void subtractionWithNegative1() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.subtraction(-5.0, 1.1);
        Assertions.assertEquals(-6.1, calculation.getResult(), "Subtraction with negative 1");
    }

    @Test
    public void subtractionWithNegative2() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.subtraction(5.0, -1.1);
        Assertions.assertEquals(6.1, calculation.getResult(), "Subtraction with negative 2");
    }

    @Test
    public void subtractionWithNegative3() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.subtraction(-5.0, -1.1);
        Assertions.assertEquals(-3.9, calculation.getResult(), "Subtraction with negative 3");
    }

    @Test
    public void multiplicationWithNull() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.multiplication(5.0, 0.0);
        Assertions.assertEquals(0.0, calculation.getResult(), "Multiplication with negative 2");
    }

    @Test
    public void multiplicationWithPositive() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.multiplication(5.0, 1.2);
        Assertions.assertEquals(6.0, calculation.getResult(), "Multiplication with negative 2");
    }

    @Test
    public void multiplicationWithNegative() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.multiplication(5.0, -1.3);
        Assertions.assertEquals(-6.5, calculation.getResult(), "Multiplication with negative 2");
    }

    @Test
    public void divisionExpectedNullDividerException() {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        NullDividerException thrown = Assertions.assertThrows(NullDividerException.class, () -> calculation.division(4.4, 0), "NullDividerException was expected");
        Assertions.assertEquals("Divider is NULL!", thrown.getMessage());
    }
}
