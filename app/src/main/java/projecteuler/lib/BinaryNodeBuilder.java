package projecteuler.lib;

import java.util.ArrayList;

/**
 * BinaryNodeBuilder.
 */
public class BinaryNodeBuilder<T> {

  ArrayList<T> leafCollector = new ArrayList<T>();

  private BinaryNode<T> build_binary_node_tree_internal(
      T[][] dataTree,
      Integer i,
      Integer j) {

    if (dataTree == null) {
      return null;
    }

    if (i < dataTree.length && j < dataTree[i].length) {
      T currentValue = dataTree[i][j];
      BinaryNode<T> resultNode = new BinaryNode<T>(dataTree[i][j]);

      if (i + 1 < dataTree.length && j + 1 < dataTree[i + 1].length) {
        resultNode.setLeft(
            this.build_binary_node_tree_internal(dataTree, i + 1, j)
        );

        resultNode.setRight(
            this.build_binary_node_tree_internal(dataTree, i + 1, j + 1)
        );
      }

      if (resultNode.isLeaf()) {
        this.leafCollector.add(currentValue);
      }

      return resultNode;

    }

    return null;
  }

  public BinaryNode<T> build_binary_node_tree(T[][] dataTree) {
    this.leafCollector = new ArrayList<T>();
    return build_binary_node_tree_internal(dataTree, 0, 0);
  }
}
