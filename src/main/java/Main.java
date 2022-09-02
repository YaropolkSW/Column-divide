import java.util.Scanner;

public class Main {
    private static final String ASK_FOR_DIVIDEND = "Введите делимое: ";
    private static final String ASK_FOR_DIVIDER = "Введите делитель: ";
    private static final String EXIT = "Exit";
    public static void main(String[] args) {

        final ColumnDivide columnDivide = new ColumnDivide();
        final Formatter formatter = new Formatter();
        final Scanner scanner = new Scanner(System.in);
        String dividendLine = null;
        while (!"exit".equalsIgnoreCase(dividendLine)) {
            System.out.print(ASK_FOR_DIVIDEND);
            dividendLine = scanner.nextLine();
            try {
                final int dividend = Integer.parseInt(dividendLine);
                System.out.print(ASK_FOR_DIVIDER);
                final int divider = Integer.parseInt(scanner.nextLine());

                final CalculationDTO calculationDTO = columnDivide.divideByColumn(dividend, divider);
                final String result = formatter.format(dividend, divider, calculationDTO);

                System.out.println(result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
