package ae.projecteuler;

import ae.projecteuler.lib.BinaryNode;
import ae.projecteuler.lib.BinaryNodeWeightBuilder;
import java.util.Arrays;
import util.Log;


/**
 * Problem 0018.
 *
 * @link Problem definition [[docs/projecteuler/problem0018.md]]
 */
public class Problem0018 {

  private Problem0018() {}


  /**
   * Problem template method.
   */
  public static Integer problem0018(Integer[][] triangle) {

    String log;
    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<>();
    BinaryNode<Integer> tree = builder.buildBinaryNodeTreeWithWeight(triangle);
    Integer[] leaves = builder.getLeaves();

    log = String.format("Triangle: %s", tree);
    Log.debug(log);
    log = String.format("Leaves count: %d, %s", leaves.length, leaves);
    Log.debug(log);

    Arrays.sort(leaves);

    Integer result = leaves[leaves.length - 1]; // maximum is last element

    log = String.format("Problem 00018 solved: %d", result);
    Log.debug(log);

    return result;
  }
}
