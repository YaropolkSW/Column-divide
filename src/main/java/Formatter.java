import java.util.List;

public class Formatter {
    private static final String MINUS = "_";
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";
    private static final String EMPTY_STRING = " ";
    private static final String NEW_LINE = "\n";

    public String format(final int dividend, final int divider, final List<Integer>[] lists) {
        final StringBuilder resultBuilder = new StringBuilder();
        final List<Integer> subtracts = lists[0];
        final List<Integer> numbers = lists[1];
        final int firstSubstractsLength = String.valueOf(subtracts.get(0)).length();
        final int dividendLength = String.valueOf(dividend).length();

        resultBuilder.append(MINUS + dividend + VERTICAL_LINE + divider + NEW_LINE + EMPTY_STRING + subtracts.get(0));
        for (int i = 0; i < dividendLength - firstSubstractsLength; i++)
            resultBuilder.append(EMPTY_STRING);
        resultBuilder.append(VERTICAL_LINE);
        for (int i = 0; i < String.valueOf(dividend / divider).length(); i++)
            resultBuilder.append(HORIZONTAL_LINE);
        resultBuilder.append(NEW_LINE + EMPTY_STRING);
        for (int i = 0; i < firstSubstractsLength; i++)
            resultBuilder.append(HORIZONTAL_LINE);
        for (int i = 0; i < dividendLength - firstSubstractsLength; i++)
            resultBuilder.append(EMPTY_STRING);
        resultBuilder.append(VERTICAL_LINE + dividend / divider + NEW_LINE);
        for (int i = 0; i < (firstSubstractsLength >= 3 ? firstSubstractsLength - 2 : firstSubstractsLength - 1); i++)
            resultBuilder.append(EMPTY_STRING);
        resultBuilder.append(MINUS + numbers.get(0) + NEW_LINE);

        int index = firstSubstractsLength == 1 ? 1 : 2;

        for (int i = 1; i < subtracts.size(); i++) {
            for (int j = 0; j < index; j++)
                resultBuilder.append(EMPTY_STRING);
            resultBuilder.append(subtracts.get(i) + NEW_LINE);
            for (int j = 0; j < index; j++)
                resultBuilder.append(EMPTY_STRING);
            for (int j = 0; j < String.valueOf(subtracts.get(i)).length(); j++)
                resultBuilder.append(HORIZONTAL_LINE);
            resultBuilder.append(NEW_LINE);
            for (int j = 0; j < index; j++)
                resultBuilder.append(EMPTY_STRING);
            resultBuilder.append((i == subtracts.size() - 1 ? EMPTY_STRING : MINUS) + numbers.get(i) + NEW_LINE);

            index++;
        }

        return resultBuilder.toString();
    }
}
