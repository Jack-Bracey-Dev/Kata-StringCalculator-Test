import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTests {

    private final StringCalculator stringCalculator;

    public StringCalculatorTests() {
        stringCalculator = new StringCalculator();
    }

    // Step one
    @Test
    public void shouldReturnZeroOnEmptyString() {
        Assert.assertEquals(0, stringCalculator.Add(""));
    }

    @Test
    public void shouldReturnThreeForZeroOneTwo() {
        Assert.assertEquals(3, stringCalculator.Add("0,1,2"));
    }

}
