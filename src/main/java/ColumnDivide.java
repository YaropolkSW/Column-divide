import java.util.ArrayList;
import java.util.List;

public class ColumnDivide {
    private static final String DIVIDER_IS_ZERO = "Нельзя делить на ноль!";
    private static final String DIVIDER_BIGGER_THAN_DIVIDEND = "Делитель больше делимого!";

    public CalculationDTO divideByColumn(final int dividend, final int divider) {
        final List<Integer> subtracts = new ArrayList<>();
        final List<Integer> numbers = new ArrayList<>();

        if (divider == 0) {
            throw new ArithmeticException(DIVIDER_IS_ZERO);
        }

        if (dividend < divider) {
            throw new ArithmeticException(DIVIDER_BIGGER_THAN_DIVIDEND);
        }

        char[] dividendCharArray = String.valueOf(dividend).toCharArray();
        int lengthOfDividend = dividendCharArray.length;
        int index = 0;
        int number = Integer.parseInt(String.valueOf(dividendCharArray[index]));

        while (lengthOfDividend > 0) {
            final int modulo;
            final int subtract;
            if (number / divider > 0 && lengthOfDividend - 1 != 0) {
                subtract = (number / divider) * divider;
                modulo = number % divider;
                number = modulo * 10 + Integer.parseInt(String.valueOf(dividendCharArray[++index]));
                subtracts.add(subtract);
                numbers.add(number);
            } else if (number / divider > 0 && lengthOfDividend - 1 == 0) {
                subtract = (number / divider) * divider;
                modulo = number % divider;
                number = modulo;
                subtracts.add(subtract);
                numbers.add(number);
            } else if (!(number / divider > 0) && lengthOfDividend - 1 != 0) {
                number = number * 10 + Integer.parseInt(String.valueOf(dividendCharArray[++index]));
            }
            lengthOfDividend--;
        }
        return new CalculationDTO(subtracts, numbers);
    }
}
