package ae.hackerrank.interview_preparation_kit.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

@TestInstance(Lifecycle.PER_CLASS)
class ArraysLeftRotationTest {

  public static class ArraysLeftRotationTestCase {
    public List<Integer> input;
    public List<Integer> expected;
  }

  List<ArraysLeftRotationTestCase> testCases;

  @BeforeAll
  public void setup() throws IOException {

    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "arrays",
        "ctci_array_left_rotation.testcases.json");

    this.testCases = JsonLoader.loadJson(path, ArraysLeftRotationTestCase.class);
  }

  @Test void testRotLeftOne() {

    for (ArraysLeftRotationTestCase test : this.testCases) {
      List<Integer> solutionFound = ArraysLeftRotation.rotLeftOne(test.input);

      assertEquals(test.expected, solutionFound,
          String.format("%s(%s) answer must be: %s",
            "CompareTriplets.compareTriplets",
            test.input,
            test.expected)
      );
    }
  }

  @Test void testRotLeft() {
    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> expected = Arrays.asList(5, 1, 2, 3, 4);
    Integer d = 4;

    List<Integer> solutionFound = ArraysLeftRotation.rotLeft(input, d);

    assertEquals(expected, solutionFound,
        String.format("%s(%s, %d) answer must be: %s",
          "CompareTriplets.compareTriplets",
          input.toString(),
          d,
          expected.toString())
    );
  }
}
