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
class Euler002Test {

  public static class Euler002TestCase {
    public Integer n;
    public Long expected;
  }

  private final List<Euler002TestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/",
        "hackerrank",
        "projecteuler",
        "euler002.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, Euler002TestCase.class));
  }

  @Test
  void euler002() {

    for (Euler002TestCase test : testCases) {
      Long solutionFound = Euler002.euler002(test.n);

      assertEquals(test.expected, solutionFound,
          "%s(%d) => must be: %s".formatted(
              "Euler002.euler002",
              test.n,
              test.expected));
    }
  }
}
