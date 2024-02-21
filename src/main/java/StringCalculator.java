import java.util.Arrays;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers == null || numbers.equals(""))
            return 0;

        String delimiter = ",";
        if (numbers.startsWith("//"))
            delimiter = numbers
                    .substring(0, numbers.indexOf("\n"))
                    .replaceAll("//", "");

        if (numbers.contains("\n"))
            numbers = numbers.replaceAll("\n", delimiter);

        return Arrays.stream(numbers.split(delimiter))
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
