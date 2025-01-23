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
class MiniMaxSumTest {

  public class MiniMaxSumTestCase {
    public List<Integer> input;
    public String expected;

    public MiniMaxSumTestCase(List<Integer> input, String expected) {
      this.input = input;
      this.expected = expected;
    }
  }

  public List<MiniMaxSumTestCase> testCases;

  @BeforeAll
  public void setup() {
    this.testCases = Arrays.asList(
      new MiniMaxSumTestCase(Arrays.asList(1, 2, 3, 4, 5), "10 14"),
      new MiniMaxSumTestCase(Arrays.asList(5, 4, 3, 2, 1), "10 14")
    );
  }

  @Test
  void testMiniMaxSum() {

    for (MiniMaxSumTestCase testCase : this.testCases) {
      String solutionFound = MiniMaxSum.miniMaxSum(testCase.input);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%s) answer must be: %s",
              "MiniMaxSum.miniMaxSum",
              testCase.input.toString(),
              testCase.expected)
      );
    }
  }

  @Test
  void testMiniMaxSumNullInput() {

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      MiniMaxSum.miniMaxSum(null);
    });

    String expectedMessage = "Parameter cannot be empty";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void testMiniMaxSumEmptyInput() {
    List<Integer> input = Arrays.asList();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      MiniMaxSum.miniMaxSum(input);
    });

    String expectedMessage = "Parameter cannot be empty";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
