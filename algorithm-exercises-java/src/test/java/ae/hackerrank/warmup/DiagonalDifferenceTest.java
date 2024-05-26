package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class DiagonalDifferenceTest {

  public class DiagonalDifferenceTestCase {
    public List<List<Integer>> matrix;
    public Integer expected;

    public DiagonalDifferenceTestCase(List<List<Integer>> _input, int _expected) {
      this.matrix = _input;
      this.expected = _expected;
    }
  }

  public List<DiagonalDifferenceTestCase> testCases;

  @BeforeAll
  public void setup() {
    this.testCases = Arrays.asList(
      new DiagonalDifferenceTestCase(Arrays.asList(
        Arrays.asList(11, 2, 4),
        Arrays.asList(4, 5, 6),
        Arrays.asList(10, 8, -12)
      ),  15)
    );
  }

  @Test void testDiagonalDifference() {

    for (DiagonalDifferenceTestCase testCase : this.testCases) {
      Integer resultFound = DiagonalDifference.diagonalDifference(testCase.matrix);

      assertEquals(testCase.expected, resultFound,
          String.format("%s(%s) answer must be: %s",
              "MiniMaxSum.miniMaxSum",
              testCase.matrix.toString(),
              testCase.expected.toString())
      );
    }
  }
}
