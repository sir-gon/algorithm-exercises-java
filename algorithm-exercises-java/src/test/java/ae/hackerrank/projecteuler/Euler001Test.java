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
    String path = String.join("/", "hackerrank", "projecteuler", "euler001.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, Euler001TestCase.class));
  }

  @Test
  void euler001() {

    for (Euler001TestCase test : testCases) {
      Long solutionFound = Euler001.euler001(test.a, test.b, test.n);

      assertEquals(
          test.expected,
          solutionFound,
          "%s(%d, %d, %d) => must be: %s"
              .formatted("Euler001.euler001", test.a, test.b, test.n, test.expected));
    }
  }

  @Test
  void euler001HelperBranches() {
    assertEquals(7L, Euler001.gcd(0, 7));
    assertEquals(3L, Euler001.gcd(3, 0));
    assertEquals(1L, Euler001.gcd(3, 5));

    assertEquals(0L, Euler001.lcm(0, 7));
    assertEquals(0L, Euler001.lcm(3, 0));
    assertEquals(15L, Euler001.lcm(3, 5));

    assertEquals(0L, Euler001.sumOfArithmeticProgression(10L, 0L));
    assertEquals(0L, Euler001.sumOfArithmeticProgression(0L, 3L));
    assertEquals(0L, Euler001.sumOfArithmeticProgression(4L, 5L));
    assertEquals(30L, Euler001.sumOfArithmeticProgression(10L, 2L));
  }

  @Test
  void euler001BorderCases() {

    Integer aIsZero = 0;
    Integer aMajorThanZero = 3;

    Integer bIsZero = 0;
    Integer bMajorThanZero = 5;

    Integer nMajorThanZero = 10;

    assertEquals(
        0L,
        Euler001.euler001(aIsZero, bIsZero, nMajorThanZero),
        "%s(%d, %d, %d) => must be: %s"
            .formatted("Euler001.euler001", aIsZero, bIsZero, nMajorThanZero, 0L));

    assertEquals(
        5L,
        Euler001.euler001(aIsZero, bMajorThanZero, nMajorThanZero),
        "%s(%d, %d, %d) => must be: %s"
            .formatted("Euler001.euler001", aIsZero, bMajorThanZero, nMajorThanZero, 5L));

    assertEquals(
        18L,
        Euler001.euler001(aMajorThanZero, bIsZero, nMajorThanZero),
        "%s(%d, %d, %d) => must be: %s"
            .formatted("Euler001.euler001", aMajorThanZero, bIsZero, nMajorThanZero, 18L));

    Integer nIsZero = 0;
    assertEquals(
        0L,
        Euler001.euler001(aMajorThanZero, bMajorThanZero, nIsZero),
        "%s(%d, %d, %d) => must be: %s"
            .formatted("Euler001.euler001", aMajorThanZero, bMajorThanZero, nIsZero, 0L));

    assertEquals(
        0L,
        Euler001.euler001(aMajorThanZero, bMajorThanZero, 1),
        "%s(%d, %d, %d) => must be: %s"
            .formatted("Euler001.euler001", aMajorThanZero, bMajorThanZero, 1, 0L));

    assertEquals(
        0L,
        Euler001.euler001(aMajorThanZero, bMajorThanZero, nIsZero),
        "%s(%d, %d, %d) => must be: %s"
            .formatted("Euler001.euler001", aIsZero, bMajorThanZero, nIsZero, 0L));
    assertEquals(
        0L,
        Euler001.euler001(aMajorThanZero, bMajorThanZero, nIsZero),
        "%s(%d, %d, %d) => must be: %s"
            .formatted("Euler001.euler001", aMajorThanZero, bIsZero, nIsZero, 0L));
    assertEquals(
        0L,
        Euler001.euler001(aMajorThanZero, bMajorThanZero, nIsZero),
        "%s(%d, %d, %d) => must be: %s"
            .formatted("Euler001.euler001", aIsZero, bIsZero, nIsZero, 0L));
  }
}
