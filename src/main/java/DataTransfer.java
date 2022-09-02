import java.util.ArrayList;
import java.util.List;

public class DataTransfer {
    private final List<Integer> subtracts;
    private final List<Integer> numbers;

    public DataTransfer(List<Integer> subtracts, List<Integer> numbers) {
        this.subtracts = subtracts;
        this.numbers = numbers;
    }

    public List<Integer> getSubtracts() {
        return subtracts;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
