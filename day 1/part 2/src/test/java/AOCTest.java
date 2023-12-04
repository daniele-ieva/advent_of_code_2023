import com.adventofcode.Calibrator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AOCTest {

    String[] test_input;
    int[] test_output;

    @Before
    public void Setup() {
        test_input = new String[]{
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"
        };
        test_output = new int[]{
                29,
                83,
                13,
                24,
                42,
                14,
                76
        };
    }

    @Test
    public void test() {
        Assert.assertEquals(test_input.length, test_output.length);
        for (int i = 0; i < test_input.length; i++) {
            Assert.assertEquals(test_output[i], Calibrator.findDigits(test_input[i]));
        }
    }
}
