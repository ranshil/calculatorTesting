package scenarios;

import calculator.Calculator;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.CalculatorPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@FixMethodOrder(MethodSorters.JVM)
public class CalculatorTest extends FunctionalTest {

/*   Test the following sequences

        1) 2 + 3 = 5
        2) 10 - 2 = 8
        3) (10 - 2) * 2 != 20
        4) sin(30) = 0.5
        5) history
 */

    @Before
    public void openSite(){
        driver.get("https://web2.0calc.com/");

    }

    @Test
    public void verifyAddition() throws InterruptedException {
        Calculator calculator = new Calculator(new CalculatorPage(driver));
        double result = calculator.addition(2,3);
        assertEquals(result,5,0);
    }

    @Test
    public void verifySubtraction() throws InterruptedException {
        Calculator calculator = new Calculator(new CalculatorPage(driver));
        double result = calculator.subtraction(10,2);
        assertEquals(result,8,0);
    }

    @Test
    public void verifyComplexEquation() throws InterruptedException {
        Calculator calculator = new Calculator(new CalculatorPage(driver));
        double result = calculator.complexEquation(10,2);
        double  notExpectedResult = 20;
        assertNotEquals(result, notExpectedResult, 0);
    }

    @Test
    public void verifySin() throws InterruptedException {
        Calculator calculator = new Calculator(new CalculatorPage(driver));
        double results = calculator.sin(30);
        assertEquals(results,0.5,0);
    }

    @Test
    public void verifyHistoryForAll() throws InterruptedException {
        Calculator calculator = new Calculator(new CalculatorPage(driver));
        calculator.verifyHistory(historyCalcStack);
    }

}

