package ae.hackerrank.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

@TestInstance(Lifecycle.PER_CLASS)
class Euler001Test {

  public static class Euler001TestCase {
    public Integer a;
    public Integer b;
    public Integer n;
    public Long expected;
  }

  private final List<Euler001TestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/",
        "hackerrank",
        "projecteuler",
        "euler001.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, Euler001TestCase.class));
  }

  @Test
  void euler001() {

    for (Euler001TestCase test : testCases) {
      Long solutionFound = Euler001.euler001(test.a, test.b, test.n);

      assertEquals(test.expected, solutionFound,
          "%s(%d, %d, %d) => must be: %s".formatted(
              "Euler001.euler001",
              test.a, test.b, test.n,
              test.expected));
    }
  }
}
