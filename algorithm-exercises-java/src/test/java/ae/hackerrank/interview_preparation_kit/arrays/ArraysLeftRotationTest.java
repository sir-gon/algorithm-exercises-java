package ae.hackerrank.interview_preparation_kit.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class ArraysLeftRotationTest {

  public JsonNode testCases;

  @BeforeAll
  public void setup() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "arrays",
        "ctci_array_left_rotation.testcases.json");
    File file = new File(
        this.getClass()
        .getClassLoader()
        .getResource(path)
        .getFile()
    );
    this.testCases = objectMapper.readTree(file);
  }

  @Test void testRotLeftOne() throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();

    for (JsonNode testCase : this.testCases) {
      int[] input  = mapper.readValue(testCase.get("input").toString(), int[].class);
      List<Integer> tlist = Arrays.stream(input).boxed().toList();
      List<Integer> solutionFound = ArraysLeftRotation.rotLeftOne(tlist);

      int[] expected  = mapper.readValue(testCase.get("expected").toString(), int[].class);
      List<Integer> texpected = Arrays.stream(expected).boxed().toList();


      assertEquals(texpected, solutionFound,
          String.format("%s(%s) answer must be: %s",
            "CompareTriplets.compareTriplets",
            testCase.get("input"),
            testCase.get("expected"))
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
