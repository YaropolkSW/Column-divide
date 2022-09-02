import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColumnDivideTest {
    private final ColumnDivide columnDivide = new ColumnDivide();
    private final Formatter formatter = new Formatter();
    @Test
    public void shouldWorkIfDividendIfBiggerThanDivider() {
        final int dividend = 78945;
        final int divider = 4;
        final String expectedString = "_78945|4\n" +
                                      " 4    |-----\n" +
                                      " -    |19736\n" +
                                      "_38\n" +
                                      " 36\n" +
                                      " --\n" +
                                      " _29\n" +
                                      "  28\n" +
                                      "  --\n" +
                                      "  _14\n" +
                                      "   12\n" +
                                      "   --\n" +
                                      "   _25\n" +
                                      "    24\n" +
                                      "    --\n" +
                                      "     1\n";

        final CalculationDTO calculationDTO = columnDivide.divideByColumn(dividend, divider);
        final String actualString = formatter.format(dividend, divider, calculationDTO);

        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldThrowExceptionIfDividerIsZero() {
        final int dividend = 8;
        final int divider = 0;
        final String message = "Нельзя делить на ноль!";
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> columnDivide.divideByColumn(dividend, divider), message);
    }

    @Test
    public void shouldThrowExceptionIfDividerIsBiggerThanDividend() {
        final int dividend = 8;
        final int divider = 16;
        final String message = "Делитель больше делимого!";
        Assertions.assertThrows(ArithmeticException.class, () -> columnDivide.divideByColumn(dividend, divider), message);
    }
}
