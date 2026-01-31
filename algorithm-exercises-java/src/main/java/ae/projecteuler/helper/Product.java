package ae.projecteuler.helper;

/** Product helper. */
public class Product {
  private Product() {}

  /** Product of array of numbers. */
  public static Long product(Long[] numList) {

    if (numList == null || numList.length == 0) {
      return 0L;
    }

    Long result = 1L;

    for (int i = 0; i < numList.length; i++) {
      result *= numList[i];
    }

    return result;
  }
}
