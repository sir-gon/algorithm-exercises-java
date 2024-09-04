package ae.hackerrank.interview_preparation_kit.arrays;

import java.util.ArrayList;
import java.util.List;


/**
 * Arrays Left Rotation.
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/arrays/ctci_array_left_rotation.md]]
 */
public class ArraysLeftRotation {

  private ArraysLeftRotation() {}

  static final int FIRST_POSITION = 0;

  /**
   * rotLeftOne.
   */
  public static List<Integer> rotLeftOne(List<Integer> a) {
    // Clone the list
    List<Integer> output = new ArrayList<>(a);

    Integer first = output.get(FIRST_POSITION);
    output.remove(FIRST_POSITION);
    output.add(first);

    return output;
  }

  /**
   * rotLeft.
   */
  public static List<Integer> rotLeft(List<Integer> a, int d) {

    // Clone the list
    List<Integer> output = new ArrayList<>(a);

    int i = 1;
    while (i <= d) {
      output = rotLeftOne(output);
      i += 1;
    }

    return output;
  }
}
