package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
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

  public List<CompareTripletsTestCase> testCases;

  @BeforeAll
  public void setup() {
    this.testCases = Arrays.asList(
      new CompareTripletsTestCase(
        Arrays.asList(5, 6, 7),
        Arrays.asList(3, 6, 10),
        Arrays.asList(1, 1))
    );
  }

  @Test void testCompareTriplets() {
    for (CompareTripletsTestCase testCase : this.testCases) {
      List<Integer> solutionFound = CompareTriplets.compareTriplets(testCase.la, testCase.lb);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%s, %s) answer must be: %s",
            "CompareTriplets.compareTriplets",
            testCase.la.toString(),
            testCase.lb.toString(),
            testCase.expected.toString())
      );
    }
  }
}
