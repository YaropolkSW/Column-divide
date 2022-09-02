import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ASK_FOR_DIVIDEND = "Введите делимое: ";
    private static final String ASK_FOR_DIVIDER = "Введите делитель: ";
    public static void main(String[] args) {

        final ColumnDivide columnDivide = new ColumnDivide();
        final Formatter formatter = new Formatter();
        final Scanner scanner = new Scanner(System.in);
        String dividendLine;
        System.out.print(ASK_FOR_DIVIDEND);

        while (!(dividendLine = scanner.nextLine()).equals("exit")) {
            final int dividend = Integer.parseInt(dividendLine);

            System.out.print(ASK_FOR_DIVIDER);
            final int divider = Integer.parseInt(scanner.nextLine());

            final List<Integer>[] lists = columnDivide.divideByColumn(dividend, divider);
            final String result = formatter.format(dividend, divider, lists);

            System.out.println(result);
            System.out.print(ASK_FOR_DIVIDEND);
        }
    }
}
