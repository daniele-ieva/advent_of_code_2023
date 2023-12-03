import com.adventofcode.ExtractionTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class D2Test {
    private ExtractionTester tester;

    private final String[] input = new String[]{
            "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
    };
    private final int[] output = new int[]{
            48,
            12,
            1560,
            630,
            36
    };

    @Before
    public void Setup() {
        tester = new ExtractionTester();
    }

    @Test
    public void Test() {
        for (int i = 0; i < input.length; i++) {
            Assert.assertEquals(output[i], tester.test(input[i]));
        }
    }
}
