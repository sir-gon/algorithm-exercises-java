package ae.hackerrank.interview_preparation_kit.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class CrushBruteForceTest {

  public static class CrushBruteForceTestCase {
    public String title;
    public Integer n;
    public List<List<Integer>> queries;
    public long expected;
  }

  List<CrushBruteForceTestCase> testCases;

  @BeforeAll
  public void setup() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "arrays",
        "crush.testcases.json");
    File file = new File(
        this.getClass()
        .getClassLoader()
        .getResource(path)
        .getFile()
    );

    ObjectMapper mapper = new ObjectMapper();
    this.testCases  = mapper.readerForListOf(CrushBruteForceTestCase.class)
        .readValue(objectMapper.readTree(file));
  }

  @Test void testArrayManipulation() {
    for (CrushBruteForceTestCase testCase : testCases) {
      long solutionFound = CrushBruteForce
          .arrayManipulation(testCase.n, testCase.queries);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%d, %s) answer must be: %s",
            "CrushBruteForce.arrayManipulation",
            testCase.n,
            testCase.queries.toString(),
            testCase.expected
          )
      );
    }
  }
}
