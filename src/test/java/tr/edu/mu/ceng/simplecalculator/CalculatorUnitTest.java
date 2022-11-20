package tr.edu.mu.ceng.simplecalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {
    @Test
    public void perfomAddition() {
        CalculatorListener listener = new MockCalculatorListener();
        SimpleCalculator calc = new SimpleCalculator(listener);
        calc.setOperand(72);
        calc.setOperator("+");
        calc.setOperand(6);
        calc.setOperator("=");
        assertEquals(78, ((MockCalculatorListener)listener).getResult());

    }
}