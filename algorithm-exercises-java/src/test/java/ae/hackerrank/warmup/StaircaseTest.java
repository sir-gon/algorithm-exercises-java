package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class StaircaseTest {
  public class StaircaseTestCase {
    public Integer input;
    public String expected;

    public StaircaseTestCase(Integer input, String expected) {
      this.input = input;
      this.expected = expected;
    }
  }

  public List<StaircaseTestCase> testCases;

  @BeforeAll
  void setup() {
    this.testCases = Arrays.asList(
        new StaircaseTestCase(
            6, String.join("\n",
                "     #",
                "    ##",
                "   ###",
                "  ####",
                " #####",
                "######")));
  }

  @Test
  void testStaircase() {
    for (StaircaseTestCase testCase : this.testCases) {
      String solutionFound = Staircase.staircase(testCase.input);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%d) answer must be: %s",
              "Staircase.staircase",
              testCase.input,
              testCase.expected));
    }
  }
}
