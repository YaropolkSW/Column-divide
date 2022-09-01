import java.util.ArrayList;
import java.util.List;

public class ColumnDivide {
    private final List<Integer> subtracts = new ArrayList<>();
    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer>[] divideByColumn(final int dividend, final int divider) {
        if (divider == 0)
            throw new ArithmeticException("Can't divide by zero!");

        final List<Integer>[] lists = new List[2];
        char[] dividendCharArray = String.valueOf(dividend).toCharArray();
        int lengthOfDividend = dividendCharArray.length;
        int index = 0;
        int number = Integer.parseInt(String.valueOf(dividendCharArray[index]));
        int modulo;
        int subtract;

        while (lengthOfDividend > 0) {
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
        lists[0] = subtracts;
        lists[1] = numbers;
        return lists;
    }
}
