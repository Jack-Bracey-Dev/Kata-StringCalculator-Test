import java.util.Arrays;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers == null || numbers.equals(""))
            return 0;

        return Arrays.stream(numbers.split(","))
                .mapToInt(value -> {
                    try {
                        return Integer.parseInt(value);
                    } catch (Exception e) {
                        return 0;
                    }
                })
                .sum();
    }

}
