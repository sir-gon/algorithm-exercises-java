package ae.hackerrank.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.JsonLoader;

@TestInstance(Lifecycle.PER_CLASS)
class Euler003Test {

  public static class Euler003TestCase {
    public Long n;
    public Long expected;
  }

  private final List<Euler003TestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/", "hackerrank", "projecteuler", "euler003.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, Euler003TestCase.class));
  }

  @Test
  void euler003() {

    for (Euler003TestCase test : testCases) {
      Long solutionFound = Euler003.euler003(test.n);

      assertEquals(
          test.expected,
          solutionFound,
          "%s(%d) => must be: %s".formatted("Euler003.euler003", test.n, test.expected));
    }
  }

  @ParameterizedTest
  @CsvSource({"0", "1"})
  void euler003edgecases(long input) {

    Exception exception;

    exception = assertThrows(IllegalArgumentException.class, () -> Euler003.euler003(input));

    String expectedMessage = "n must be greater than 2";

    assertTrue(exception.getMessage().contains(expectedMessage));
  }
}
