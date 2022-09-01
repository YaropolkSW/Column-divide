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
        final StringBuilder testBuilder = new StringBuilder();
        testBuilder.append("_78945|4\n").append(" 4    |-----\n").append(" -    |19736\n").append("_38\n")
                .append(" 36\n").append(" --\n").append(" _29\n").append("  28\n")
                .append("  --\n").append("  _14\n").append("   12\n").append("   --\n")
                .append("   _25\n").append("    24\n").append("    --\n").append("     1\n");

        final List<Integer>[] lists = columnDivide.divideByColumn(dividend, divider);
        final String actualString = formatter.format(dividend, divider, lists);

        Assertions.assertEquals(testBuilder.toString(), actualString);
    }
}
