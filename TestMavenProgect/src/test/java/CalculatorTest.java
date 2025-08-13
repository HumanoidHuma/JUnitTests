import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.Calculator;


public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Тест сложения положительных чисел")
    void givenNumbers_whenMinus_thenReturnCorrectMin() {
        // Arrange
        int a = 23;
        int b = 10;

        // Act
        int result = calculator.add(a, b);

        // Assert
        Assertions.assertEquals(result, 13);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @DisplayName("Параметризованный тест положительных чисел")
    @CsvSource({
            "1, 1, 2",
            "2, 2, 4",
            "4, 4, 8",
            "-5, 5, 0",
            "-10, 23, 13"
    })
    void add_VariousNumbers_ReturnCorrectSum(int a, int b, int expected) {
        int result = calculator.add(a, b);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест выбрасывания исключения при делении на ноль")
    void givenZeroDivisor_whenDivide_thenThrowArithmeticException() {
        int a = 20;
        int b = 0;

        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @DisplayName("Параметризованный тест умножения любых чисел")
    @CsvSource({
            "1, 1, 1",
            "-1, 1, -1",
            "10, -10, -100",
            "-5, -5, 25"
    })
    void givenNumbers_whenMultiply_thenReturnCorrectMultiply(int a, int b, int expected) {
        int result = calculator.multiply(a, b);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @DisplayName("Параметризованный тест деления вещественных чисел")
    @CsvSource({
            "1.0, 1.0, 1.0",
            "-1.0, 5.0, -0.2",
            "10.0, 2.0, 5.0"
    })
    void givenDoubles_whenDivide_thenReturnCorrectDivide(double a, double b, double expected) {
        double result = calculator.divide(a, b);

        Assertions.assertEquals(expected, result);
    }
}
