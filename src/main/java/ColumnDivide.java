import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColumnDivide {
    private static final String DIVIDER_IS_ZERO = "Нельзя делить на ноль, введите новый делитель: ";
    private static final String DIVIDER_BIGGER_THAN_DIVIDEND = "Делитель больше делимого, введите новый делитель: ";

    public List<Integer>[] divideByColumn(final int dividend, final int divider) {
        final Scanner scanner = new Scanner(System.in);
        final int newDivider;
        final List<Integer> subtracts = new ArrayList<>();
        final List<Integer> numbers = new ArrayList<>();
/*
        if (divider == 0) {
            try {
                throw new ArithmeticException(DIVIDER_IS_ZERO);
            } catch (ArithmeticException e) {
                System.out.print(e.getMessage());
                newDivider = Integer.parseInt(scanner.nextLine());
                divideByColumn(dividend, newDivider);
            }
        }
*/
        try {
            if (divider == 0) {
                throw new ArithmeticException(DIVIDER_IS_ZERO);
            }
        } catch (ArithmeticException ex) {
            System.out.print(ex.getMessage());
            newDivider = Integer.parseInt(scanner.nextLine());
            divideByColumn(dividend, newDivider);
        }
/*
        if (divider == 0) {
            System.out.print(DIVIDER_IS_ZERO);
            newDivider = scanner.nextInt();
            divideByColumn(dividend, newDivider);
        }
*/
        final List<Integer>[] lists = new List[2];
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
        lists[0] = subtracts;
        lists[1] = numbers;
        return lists;
    }
}
