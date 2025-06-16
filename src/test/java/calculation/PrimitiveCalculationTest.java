package calculation;

import exeptions.NullDividerException;
import org.junit.jupiter.api.Test;

public class PrimitiveCalculationTest {
    @Test( expected = NullDividerException.class)
    public void divisionCalc_7() throws NullDividerException {
        PrimitiveCalculation calculation = new PrimitiveCalculation();
        calculation.division(4.4, 0);
    }
}
