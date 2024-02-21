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

    // Step two
    @Test
    public void shouldReturnOneHundredAndTwenty() {
        Assert.assertEquals(120, stringCalculator.Add("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15"));
    }

}
