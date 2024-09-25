package ae.hackerrank.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;


@TestInstance(Lifecycle.PER_CLASS)
class Euler003Test {

  public static class Euler003TestCase {
    public Long n;
    public Long expected;
  }

  private List<Euler003TestCase> testCases;

  @BeforeAll
  public void setup() throws IOException {
    String path = String.join("/",
         "hackerrank",
        "projecteuler",
        "euler003.testcases.json");

    this.testCases = JsonLoader.loadJson(path, Euler003TestCase.class);
  }

  @Test void euler003() {

    for (Euler003TestCase test : testCases) {
      Long solutionFound = Euler003.euler003(test.n);

      assertEquals(test.expected, solutionFound,
          "%s(%d) => must be: %s".formatted(
            "Euler003.euler003",
            test.n,
            test.expected
          )
      );
    }
  }
}
