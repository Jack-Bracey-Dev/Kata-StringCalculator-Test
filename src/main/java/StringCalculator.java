import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int Add(String numbers) throws Exception {
        if (numbers == null || numbers.equals(""))
            return 0;

        String delimiter = ",";
        if (numbers.startsWith("//"))
            delimiter = numbers
                    .substring(0, numbers.indexOf("\n"))
                    .replaceAll("//", "");

        List<String> negatives = findRegex(numbers, "(-[0-9])");
        if (negatives.size() > 0)
            throw new Exception("Negatives not allowed: " + String.join(",", negatives));

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

    private List<String> findRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

}
