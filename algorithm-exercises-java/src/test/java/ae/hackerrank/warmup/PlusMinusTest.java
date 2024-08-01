package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class PlusMinusTest {

  public class PlusMinusTestCase {
    public List<Integer> input;
    public String expected;

    public PlusMinusTestCase(List<Integer> input, String expected) {
      this.input = input;
      this.expected = expected;
    }
  }

  public List<PlusMinusTestCase> testCases;

  @BeforeAll
  public void setup() {
    this.testCases = Arrays.asList(
        new PlusMinusTestCase(
            Arrays.asList(-4, 3, -9, 0, 4, 1),
            String.join("\n", "0.500000", "0.333333", "0.166667")));
  }

  @Test
  void testPlusMinus() {

    for (PlusMinusTestCase testCase : this.testCases) {
      String solutionFound = PlusMinus.plusMinus(testCase.input);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%s) answer must be: %s",
              "PlusMinus.plusMinus",
              testCase.input.toString(),
              testCase.expected.toString()));
    }
  }
}
