package ae.hackerrank.interview_preparation_kit.miscellaneous;

/**
 * AngryFlorist.
 *
 * @link Problem definition
 *     [[docs/hackerrank/interview_preparation_kit/miscellaneous/flipping-bits.md]]
 */
public class FlippingBitsAlternative {

  private FlippingBitsAlternative() {}

  /** flippingBits. */
  public static long flippingBits(long n) {
    return ~n & 0xFFFFFFFFL; // Use bitwise NOT and mask to ensure 32-bit unsigned result
  }
}
