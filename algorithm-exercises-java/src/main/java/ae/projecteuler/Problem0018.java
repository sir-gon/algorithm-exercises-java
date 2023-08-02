// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

import ae.projecteuler.lib.BinaryNode;
import ae.projecteuler.lib.BinaryNodeWeightBuilder;
import java.util.Arrays;


/**
 * Problem 0018.
 */
public class Problem0018 {

  private Problem0018() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem template method.
   */
  public static Integer problem0018(Integer[][] triangle) {

    String log;
    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<>();
    BinaryNode<Integer> tree = builder.buildBinaryNodeTreeWithWeight(triangle);
    Integer[] leaves = builder.getLeaves();

    log = String.format("Triangle: %s", tree);
    logger.fine(log);
    log = String.format("Leaves count: %d, %s", leaves.length, leaves);
    logger.fine(log);

    Arrays.sort(leaves);

    Integer result = leaves[leaves.length - 1]; // maximum is last element

    log = String.format("Problem 00018 solved: %d", result);
    logger.fine(log);

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
