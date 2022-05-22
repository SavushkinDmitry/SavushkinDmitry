import org.mockito.InOrder;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.CalculatorFunction;
import services.CalculatorImpl;
import services.IOService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class CalculatorImplTest {

    private IOService ioService;
    private InOrder inOrder;
    private CalculatorFunction calculatorFunction;

    @BeforeMethod
    void setUp() {
        ioService = Mockito.mock(IOService.class);
        calculatorFunction = new CalculatorImpl(ioService);
        inOrder = inOrder(ioService);
    }

    @DataProvider
    public Object[][] testMultiply() {
        return new Object[][] {
                {"2 * 2 = 4", "2", "2"},
                {"2 * -3 = -6", "2", "-3"}
        };
    }

    @DataProvider
    public Object[][] testDivide() {
        return new Object[][] {
                {"2 / 2 = 1", "2", "2"},
                {"6 / 2 = 3", "6", "2"}
        };
    }

    @DataProvider
    public Object[][] testSum() {
        return new Object[][] {
                {"10 + 5 = 15", "10", "5"},
                {"6 + 2 = 8", "6", "2"}
        };
    }

    @DataProvider
    public Object[][] testSubtract() {
        return new Object[][] {
                {"5 - 1 = 4", "5", "1"},
                {"-3 - 3 = -6",  "-3", "3"}
        };
    }

    @Test(dataProvider = "testMultiply")
    public void twoDigitsMultiply(String result, String n1, String n2) {
        given(ioService.readMessage()).willReturn(n1).willReturn(n2);
        calculatorFunction.readTwoDigitsAndMultiply(result);
        inOrder.verify(ioService, times(2)).readMessage();
        inOrder.verify(ioService, times(1)).out(result);
    }

    @Test(dataProvider = "testDivide")
    public void twoDigitsDivide(String result, String n1, String n2) {
        given(ioService.readMessage()).willReturn(n1).willReturn(n2);
        calculatorFunction.readTwoDigitsAndDivide(result);
        inOrder.verify(ioService, times(2)).readMessage();
        inOrder.verify(ioService, times(1)).out(result);
    }

    @Test(dataProvider = "testSum")
    public void twoDigitsSum(String result, String n1, String n2) {
        given(ioService.readMessage()).willReturn(n1).willReturn(n2);
        calculatorFunction.readTwoDigitsAndSum(result);
        inOrder.verify(ioService, times(2)).readMessage();
        inOrder.verify(ioService, times(1)).out(result);
    }

    @Test(dataProvider = "testSubtract")
    public void twoDigitsSubtract(String result, String n1, String n2) {
        given(ioService.readMessage()).willReturn(n1).willReturn(n2);
        calculatorFunction.readTwoDigitsAndSubtract(result);
        inOrder.verify(ioService, times(2)).readMessage();
        inOrder.verify(ioService, times(1)).out(result);
    }


}
