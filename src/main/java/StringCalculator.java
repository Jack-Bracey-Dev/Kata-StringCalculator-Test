import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int Add(String numbers) throws Exception {
        if (numbers == null || numbers.equals(""))
            return 0;

        List<String> delimiters = new ArrayList<>();
        if (numbers.startsWith("//")) {
            List<String> possibleDelimiter = findRegex(numbers, "\\/\\/\\[.*\\]");
            if (possibleDelimiter.size() > 0) {
                String stripped = possibleDelimiter.get(0).replace("//", "");

                while(stripped.contains("[") && stripped.contains("]")) {
                    delimiters.add(stripped
                            .substring(stripped.indexOf("["), stripped.indexOf("]")+1)
                            .replace("[", "")
                            .replace("]", ""));
                    stripped = stripped.substring(stripped.indexOf("]")+1);
                }

                numbers = numbers.replace(possibleDelimiter.get(0), "");
            } else {
                delimiters.add(numbers
                        .substring(0, numbers.indexOf("\n"))
                        .replaceAll("//", ""));
            }
        }

        if (delimiters.size() == 0)
            delimiters.add(",");

        List<String> negatives = findRegex(numbers, "(-[0-9])");
        if (negatives.size() > 0)
            throw new Exception("Negatives not allowed: " + String.join(",", negatives));

        if (numbers.contains("\n"))
            numbers = numbers.replaceAll("\n", ",");

        for (String delimiter : delimiters)
            numbers = numbers.replaceAll(delimiter, ",");

        return Arrays.stream(numbers.split(","))
                .mapToInt(value -> {
                    try {
                        int integer = Integer.parseInt(value);
                        if (integer > 1000)
                            return 0;
                        return integer;
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
