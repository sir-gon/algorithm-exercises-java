package ae.hackerrank.interview_preparation_kit.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
  * 2D Array - DS.
  *
  * @link Problem definition [[docs/hackerrank/interview_preparation_kit/arrays/2d_array.md]]
  */

public class TwoDarray {
  private TwoDarray() { }

  private static List<Integer> getHourGlass(List<List<Integer>> arr, int positionX, int positionY) {
    List<Integer> result = new ArrayList<>();

    // top
    result.add(arr.get(positionX - 1).get(positionY - 1));
    result.add(arr.get(positionX - 1).get(positionY));
    result.add(arr.get(positionX - 1).get(positionY + 1));

    // middle
    result.add(arr.get(positionX).get(positionY));

    // bottom
    result.add(arr.get(positionX + 1).get(positionY - 1));
    result.add(arr.get(positionX + 1).get(positionY));
    result.add(arr.get(positionX + 1).get(positionY + 1));

    return result;
  }

  /**
   * hourglassSum.
   */
  public static Integer hourglassSum(List<List<Integer>> arr) {
    int matrixSize = 0;

    if (arr == null) {
      return null;
    }

    matrixSize = arr.size();

    int matrixStartIndex = 1;
    int matrixEndIndex = matrixSize - 2;

    Integer maxHourGlassSum = null;

    for (int i = matrixStartIndex; i <= matrixEndIndex; i++) {
      for (int j = matrixStartIndex; j <= matrixEndIndex; j++) {
        List<Integer> currentHourGlass = getHourGlass(arr, i, j);
        int hourGlassSum = currentHourGlass.stream()
                                           .collect(Collectors.summingInt(Integer::intValue));

        if (maxHourGlassSum == null || hourGlassSum > maxHourGlassSum) {
          maxHourGlassSum = hourGlassSum;
        }
      }
    }

    return maxHourGlassSum;
  }
}
