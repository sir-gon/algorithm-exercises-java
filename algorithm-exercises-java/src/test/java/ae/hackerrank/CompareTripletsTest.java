package ae.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


class CompareTripletsTest {

  public class CompareTripletsTestCase {
    public List<Integer> la;
    public List<Integer> lb;
    public List<Integer> expected;

    public CompareTripletsTestCase(List<Integer> _la, List<Integer> _lb, List<Integer> _expected) {
      this.la = _la;
      this.lb = _lb;
      this.expected = _expected;
    }
  }

  @Test void testCompareTriplets() {

    CompareTripletsTestCase[] testCases = {
      new CompareTripletsTestCase(
        Arrays.asList(5, 6, 7),
        Arrays.asList(3, 6, 10),
        Arrays.asList(1, 1)
      )
    };

    for (CompareTripletsTestCase testCase : testCases) {
      List<Integer> solutionFound = CompareTriplets.compareTriplets(testCase.la, testCase.lb);

      assertEquals(testCase.expected, solutionFound,
          String.format(
            "CompareTriplets.compareTriplets() answer must be: %s",
            testCase.expected.toString()
          )
      );
    }
  }
}
