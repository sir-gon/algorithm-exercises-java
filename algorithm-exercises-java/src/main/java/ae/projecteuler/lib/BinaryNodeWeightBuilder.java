package ae.projecteuler.lib;

import java.util.ArrayList;

/**
 * BinaryNodeBuilder.
 */
public class BinaryNodeWeightBuilder<T>
    extends BinaryNodeBuilder<T> {

  ArrayList<Integer> leafCollector = new ArrayList<Integer>();

  private BinaryNode<Integer> build_binary_node_tree_with_weight_internal(
      Integer[][] dataTree,
      int i,
      int j,
      int rootValue) {

    if (dataTree == null) {
      return null;
    }

    if (i < dataTree.length /* && j < dataTree[i].length */) {
      int currentValue = dataTree[i][j] + rootValue;
      BinaryNode<Integer> resultNode = new BinaryNode<Integer>(Integer.valueOf(currentValue));

      if (i + 1 < dataTree.length && j + 1 < dataTree[i + 1].length) {
        resultNode.setLeft(
            this.build_binary_node_tree_with_weight_internal(
              dataTree,
              i + 1,
              j,
              currentValue
              )
        );

        resultNode.setRight(
            this.build_binary_node_tree_with_weight_internal(
              dataTree,
              i + 1,
              j + 1,
              currentValue
              )
        );
      }

      if (resultNode.isLeaf()) {
        this.leafCollector.add(currentValue);
      }

      return resultNode;

    }

    return null;
  }

  public BinaryNode<Integer> build_binary_node_tree_with_weight(Integer[][] dataTree) {
    this.leafCollector = new ArrayList<Integer>();
    return build_binary_node_tree_with_weight_internal(dataTree, 0, 0, 0);
  }

  public Integer[] getLeaves() {
    return this.leafCollector.toArray(Integer[]::new);
  }
}
