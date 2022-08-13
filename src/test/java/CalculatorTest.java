import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorTest {
    Calculator calculator;

    @Parameters("url")
    @BeforeSuite
    public void setUp(String url) {
        System.out.println(url);
        calculator = new Calculator();
    }

    @Test(dataProvider = "anotherProvider",dataProviderClass = CalaculatorDataProvider.class)
    public void tcDividePositive(int a, int b, int ex) {
        System.out.println(Thread.currentThread().getName());
        Assert.assertEquals(calculator.divide(a,b),ex);
    }

    @Test( expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = "Value of b can' be zero")
    public void tcDividePositive2() {
        System.out.println(Thread.currentThread().getName());
        int outcome = calculator.divide(4,0);
    }

    @Test(dataProvider = "sumProvider", dataProviderClass = CalaculatorDataProvider.class)
    public void testPositive(int num1, int num2, int expectation) {
        System.out.println(Thread.currentThread().getName());
        int outcome = calculator.sum(4,0);
        Assert.assertEquals(outcome,4);
    }

    @Test(dependsOnMethods ="tcDividePositive2" )
    public void testIWantSkip(){
        System.out.println(Thread.currentThread().getName());
    }

}
