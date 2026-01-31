package ae.projecteuler.lib;

import java.util.ArrayList;

/** BinaryNodeBuilder. */
public class BinaryNodeBuilder<T> {

  private ArrayList<T> leafCollector = new ArrayList<>();

  private BinaryNode<T> buildBinaryNodeTreeInternal(T[][] dataTree, Integer i, Integer j) {

    if (dataTree == null) {
      return null;
    }

    if (i < dataTree.length /* && j < dataTree[i].length */) {
      T currentValue = dataTree[i][j];
      BinaryNode<T> resultNode = new BinaryNode<>(dataTree[i][j]);

      if (i + 1 < dataTree.length && j + 1 < dataTree[i + 1].length) {
        resultNode.setLeft(this.buildBinaryNodeTreeInternal(dataTree, i + 1, j));

        resultNode.setRight(this.buildBinaryNodeTreeInternal(dataTree, i + 1, j + 1));
      }

      if (resultNode.isLeaf()) {
        this.leafCollector.add(currentValue);
      }

      return resultNode;
    }

    return null;
  }

  public BinaryNode<T> buildBinaryNodeTree(T[][] dataTree) {
    this.leafCollector = new ArrayList<>();
    return buildBinaryNodeTreeInternal(dataTree, 0, 0);
  }
}
