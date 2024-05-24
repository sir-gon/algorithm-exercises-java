package ae.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


class DiagonalDifferenceTest {

  @Test void testDiagonalDifference() {

    List<List<Integer>> matrix = Arrays.asList(
        Arrays.asList(11, 2, 4),
        Arrays.asList(4, 5, 6),
        Arrays.asList(10, 8, -12)
    );
    Integer expected = 15;
    Integer resultFound = DiagonalDifference.diagonalDifference(matrix);

    assertEquals(expected, resultFound,
        String.format("DiagonalDifference.diagonalDifference answer must be: %d", expected)
    );
  }
}
