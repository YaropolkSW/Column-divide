import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ColumnDivideTest {
    private final ColumnDivide columnDivide = new ColumnDivide();
    private final Formatter formatter = new Formatter();
    @Test
    public void shouldFormatCorrectly() {
        final int dividend = 78945;
        final int divider = 4;
        final String expectedString = "_78945|4\n 4    |-----\n -    |19736\n_38\n 36\n --\n _29\n  28\n" +
                "  --\n  _14\n   12\n   --\n   _25\n    24\n    --\n     1\n";

        final List<Integer>[] lists = columnDivide.divideByColumn(dividend, divider);
        final String actualString = formatter.format(dividend, divider, lists);

        Assertions.assertEquals(expectedString, actualString);
    }
}
