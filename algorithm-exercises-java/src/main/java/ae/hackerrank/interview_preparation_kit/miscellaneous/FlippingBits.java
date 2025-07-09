package ae.hackerrank.interview_preparation_kit.miscellaneous;

/**
 * AngryFlorist.
 *
 * @link Problem definition
 *       [[docs/hackerrank/interview_preparation_kit/miscellaneous/flipping-bits.md]]
 */
public class FlippingBits {

  private FlippingBits() {}

  /**
   * flippingBits.
   */
  public static long flippingBits(long n) {
    String binaryString = Long.toBinaryString(n);
    binaryString = String.format("%32s", binaryString); // Ensure 32 bits

    StringBuilder resultBinaryString = new StringBuilder();

    for (int i = 0; i < binaryString.length(); i++) {
      char binDigit = binaryString.charAt(i);

      if (binDigit == '1') {
        resultBinaryString.append('0');
      } else {
        resultBinaryString.append('1');
      }
    }

    return Long.parseLong(resultBinaryString.toString(), 2);
  }
}
