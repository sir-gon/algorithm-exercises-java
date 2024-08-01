package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class BirthdayCakeCandlesTest {
  public class BirthdayCakeCandlesTestCase {
    public List<Integer> candles;
    public Integer expected;

    public BirthdayCakeCandlesTestCase(List<Integer> candles, Integer expected) {
      this.candles = candles;
      this.expected = expected;
    }
  }

  public List<BirthdayCakeCandlesTestCase> testCases;

  @BeforeAll
  public void setup() {
    this.testCases = Arrays.asList(
      new BirthdayCakeCandlesTestCase(
        Arrays.asList(3, 2, 1, 3),
        2
      ),
      new BirthdayCakeCandlesTestCase(
        Arrays.asList(1, 2, 3, 3),
        2
      )
    );
  }

  @Test void birthdayCakeCandles() {
    for (BirthdayCakeCandlesTestCase testCase : this.testCases) {
      Integer solutionFound = BirthdayCakeCandles.birthdayCakeCandles(testCase.candles);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%s) answer must be: %d",
            "CompareTriplets.compareTriplets",
            testCase.candles.toString(),
            testCase.expected)
      );
    }
  }

  @Test
  void testMiniMaxSumNullInput() {

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      BirthdayCakeCandles.birthdayCakeCandles(null);
    });

    String expectedMessage = "Parameter cannot be empty";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void testMiniMaxSumEmptyInput() {
    List<Integer> input = Arrays.asList();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      BirthdayCakeCandles.birthdayCakeCandles(input);
    });

    String expectedMessage = "Parameter cannot be empty";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
