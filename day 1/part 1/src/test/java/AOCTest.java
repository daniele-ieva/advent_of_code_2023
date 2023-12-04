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
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"
        };
        test_output = new int[]{
                12,
                38,
                15,
                77
        };
    }

    @Test
    public void test() {
        Assert.assertEquals(test_input.length, test_output.length);
        for (int i = 0; i < test_input.length; i++) {
            Assert.assertEquals(Calibrator.findDigits(test_input[i]), test_output[i]);
        }
    }
}
