import java.util.List;

public class Formatter {
    private static final String MINUS = "_";
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";
    private static final String NEW_LINE = "\n";

    public String format(final int dividend, final int divider, final List<Integer>[] lists) {
        final StringBuilder resultBuilder = new StringBuilder();
        final List<Integer> subtracts = lists[0];
        final List<Integer> numbers = lists[1];
        final int firstSubstractLength = String.valueOf(subtracts.get(0)).length();
        final int dividendLength = String.valueOf(dividend).length();

        resultBuilder.append(MINUS + dividend + VERTICAL_LINE + divider + NEW_LINE + SPACE + subtracts.get(0));
        for (int i = 0; i < dividendLength - firstSubstractLength; i++) {
            resultBuilder.append(SPACE);
        }
        resultBuilder.append(VERTICAL_LINE);
        for (int i = 0; i < String.valueOf(dividend / divider).length(); i++) {
            resultBuilder.append(HORIZONTAL_LINE);
        }
        resultBuilder.append(NEW_LINE + SPACE);
        for (int i = 0; i < firstSubstractLength; i++) {
            resultBuilder.append(HORIZONTAL_LINE);
        }
        for (int i = 0; i < dividendLength - firstSubstractLength; i++) {
            resultBuilder.append(SPACE);
        }
        resultBuilder.append(VERTICAL_LINE + dividend / divider + NEW_LINE);

        if (subtracts.size() == 1 && subtracts.get(0) == dividend) {
            for (int i = 0; i < firstSubstractLength - 1; i++) {
                resultBuilder.append(SPACE);
            }
            resultBuilder.append(SPACE + numbers.get(0) + NEW_LINE);
        } else if (subtracts.size() == 1 && subtracts.get(0) != dividend) {
            for (int i = 0; i < dividendLength - firstSubstractLength; i++) {
                resultBuilder.append(SPACE);
            }
            resultBuilder.append(SPACE + numbers.get(0) + NEW_LINE);
        } else {
            int j = 0;
            while (String.valueOf(String.valueOf(dividend).charAt(j)).equals(String.valueOf(String.valueOf(subtracts.get(0)).charAt(j))) && j < firstSubstractLength) {
                resultBuilder.append(SPACE);
                j++;
            }
            resultBuilder.append(MINUS + numbers.get(0) + NEW_LINE);
        }

        for (int i = 1; i < subtracts.size(); i++) {

            for (int j = 0; j < i; j++) {
                resultBuilder.append(SPACE);
            }
            resultBuilder.append(subtracts.get(i) + NEW_LINE);
            for (int j = 0; j < i; j++) {
                resultBuilder.append(SPACE);
            }
            for (int j = 0; j < String.valueOf(subtracts.get(i)).length(); j++) {
                resultBuilder.append(HORIZONTAL_LINE);
            }
            resultBuilder.append(NEW_LINE);
            for (int j = 0; j < i + String.valueOf(subtracts.get(i)).length() - String.valueOf(numbers.get(i)).length(); j++) {
                resultBuilder.append(SPACE);
            }
            resultBuilder.append((i == subtracts.size() - 1 ? EMPTY_STRING : MINUS) + numbers.get(i) + NEW_LINE);

        }

        return resultBuilder.toString();
    }
}
