package ae.hackerrank.interview_preparation_kit.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
  class ArraysLeftRotationTest {

  public class ArraysLeftRotationTestCase {
    public List<Integer> input;
    public List<Integer> expected;

    public ArraysLeftRotationTestCase(List<Integer> input, List<Integer> expected) {
      this.input = input;
      this.expected = expected;
    }
  }

  public class ArraysLeftRotationsTestCase {
    public List<Integer> input;
    public Integer d;
    public List<Integer> expected;

    public ArraysLeftRotationsTestCase(List<Integer> input, Integer d, List<Integer> expected) {
      this.input = input;
      this.d = d;
      this.expected = expected;
    }
  }

  public List<ArraysLeftRotationTestCase> testCases;
  public List<ArraysLeftRotationsTestCase> testRotationsCases;

  @BeforeAll
  public void setup() {
    this.testCases = Arrays.asList(
      new ArraysLeftRotationTestCase(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(2, 3, 4, 5, 1)),
      new ArraysLeftRotationTestCase(Arrays.asList(2, 3, 4, 5, 1), Arrays.asList(3, 4, 5, 1, 2)),
      new ArraysLeftRotationTestCase(Arrays.asList(3, 4, 5, 1, 2), Arrays.asList(4, 5, 1, 2, 3)),
      new ArraysLeftRotationTestCase(Arrays.asList(4, 5, 1, 2, 3), Arrays.asList(5, 1, 2, 3, 4)),
      new ArraysLeftRotationTestCase(Arrays.asList(5, 1, 2, 3, 4), Arrays.asList(1, 2, 3, 4, 5))
    );

    this.testRotationsCases = Arrays.asList(
      new ArraysLeftRotationsTestCase(
        Arrays.asList(1, 2, 3, 4, 5),
        4,
        Arrays.asList(5, 1, 2, 3, 4))
    );
  }

  @Test void testRotLeftOne() {
    for (ArraysLeftRotationTestCase testCase : this.testCases) {
      List<Integer> solutionFound = ArraysLeftRotation.rotLeftOne(testCase.input);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%s) answer must be: %s",
            "CompareTriplets.compareTriplets",
            testCase.input.toString(),
            testCase.expected.toString())
      );
    }
  }

  @Test void testRotLeft() {
    for (ArraysLeftRotationsTestCase testCase : this.testRotationsCases) {
      List<Integer> solutionFound = ArraysLeftRotation.rotLeft(testCase.input, testCase.d);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%s, %d) answer must be: %s",
            "CompareTriplets.compareTriplets",
            testCase.input.toString(),
            testCase.d,
            testCase.expected.toString())
      );
    }
  }

}
