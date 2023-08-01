package ae.projecteuler.helper;

/**
 * Sum helper.
 */
public class Sum {
  private Sum() {}

  /**
   * Sum of array of numbers.
   */
  public static Integer sum(Integer[] numList) {

    if (numList == null || numList.length == 0) {
      return 0;
    }

    Integer result = 0;

    for (int i = 0; i < numList.length; i++) {
      result += numList[i];
    }

    return result;
  }

  /**
   * Sum of array of numbers.
   */
  public static Long sum(Long[] numList) {

    if (numList == null || numList.length == 0) {
      return 0L;
    }

    Long result = 0L;

    for (int i = 0; i < numList.length; i++) {
      result += numList[i];
    }

    return result;
  }
}
