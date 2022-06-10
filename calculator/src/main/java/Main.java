import services.CalculatorFunction;
import services.CalculatorImpl;
import services.ConsoleIOService;
import services.IOService;

public class Main {
    public static void main(String[] args) {

        IOService consoleIO = new ConsoleIOService();

        consoleIO.out("��� �����������!");

        CalculatorFunction calculatorFunction = new CalculatorImpl(consoleIO);

        calculatorFunction.readTwoDigitsAndMultiply("������� �� ������� ��� ����� � �� �� ����������");
        consoleIO.out("-----------------------------------");
        calculatorFunction.readTwoDigitsAndDivide();
        consoleIO.out("-----------------------------------");
        calculatorFunction.readTwoDigitsAndSum("������� �� ������� ��� ����� � �� �� ������");
        consoleIO.out("-----------------------------------");
        calculatorFunction.readTwoDigitsAndSubtract();
        consoleIO.out("-----------------------------------");
    }
}
