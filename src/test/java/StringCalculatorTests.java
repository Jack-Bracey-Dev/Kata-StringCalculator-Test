import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTests {

    private final StringCalculator stringCalculator;

    public StringCalculatorTests() {
        stringCalculator = new StringCalculator();
    }

    // Step one
    @Test
    public void shouldReturnZeroOnEmptyString() throws Exception {
        Assert.assertEquals(0, stringCalculator.Add(""));
    }

    @Test
    public void shouldReturnThreeForZeroOneTwo() throws Exception {
        Assert.assertEquals(3, stringCalculator.Add("0,1,2"));
    }

    // Step two
    @Test
    public void shouldReturnOneHundredAndTwenty() throws Exception {
        Assert.assertEquals(120, stringCalculator.Add("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15"));
    }

    // Step three
    @Test
    public void shouldReturnCorrectValueWithNewLinesInInput() throws Exception {
        Assert.assertEquals(6, stringCalculator.Add("1\n2,3"));
    }

    @Test
    public void shouldReturnCorrectValueWithNewLinesInInputTwo() throws Exception {
        Assert.assertEquals(1, stringCalculator.Add("1,\\n"));
    }

    // Step four
    @Test
    public void shouldAllowForSpecifiedDelimiter() throws Exception {
        Assert.assertEquals(3, stringCalculator.Add("//;\n1;2"));
    }

    // Step five
    @Test
    public void shouldNotAllowNegatives() {
        Exception exception = Assert.assertThrows(Exception.class, () -> stringCalculator.Add("-1,2"));
        Assert.assertEquals("Negatives not allowed: -1", exception.getMessage());
    }

    @Test
    public void shouldNotAllowNegativesTwo() {
        Exception exception = Assert.assertThrows(Exception.class, () -> stringCalculator.Add("2,-4,3,-5"));
        Assert.assertEquals("Negatives not allowed: -4,-5", exception.getMessage());
    }

    // Step 6
    @Test
    public void shouldIgnoreNumbersGreaterThanOneThousand() throws Exception {
        Assert.assertEquals(2, stringCalculator.Add("1001,2"));
    }

    // Step 7
    @Test
    public void shouldAllowDelimitersOfAnyLength() throws Exception {
        Assert.assertEquals(6, stringCalculator.Add("//[|||]\n1|||2|||3"));
    }

}
