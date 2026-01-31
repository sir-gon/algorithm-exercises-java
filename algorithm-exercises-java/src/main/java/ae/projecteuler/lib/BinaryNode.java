package ae.projecteuler.lib;

/** BinaryNode. */
public class BinaryNode<T> {
  T value;
  BinaryNode<T> left;
  BinaryNode<T> right;

  BinaryNode() {}

  BinaryNode(T value) {
    this.value = value;
  }

  BinaryNode(BinaryNode<T> node) {
    this.value = node.getValue();
  }

  BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public BinaryNode<T> setValue(T value) {
    this.value = value;
    return this;
  }

  public T getValue() {
    return value;
  }

  public BinaryNode<T> setLeft(BinaryNode<T> left) {
    this.left = left;
    return this;
  }

  public BinaryNode<T> getLeft() {
    return left;
  }

  public BinaryNode<T> setRight(BinaryNode<T> right) {
    this.right = right;
    return this;
  }

  public BinaryNode<T> getRight() {
    return right;
  }

  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }

  public String getType() {
    return this.value.getClass().getName();
  }

  public int hashCode() {
    return this.value.hashCode();
  }

  /** equals. */
  public boolean equals(Object obj) {
    // Same instance
    if (this == obj) {
      return true;
    }

    // Same class
    if (!(obj instanceof BinaryNode)) {
      return false;
    }

    BinaryNode<?> comparing = (BinaryNode<?>) obj;

    // both values are null
    if (this.getValue() == null && comparing.getValue() == null) {
      return true;
    }

    // Only one is null
    if (this.getValue() != null ^ comparing.getValue() != null) {
      return false;
    }

    // Same generic
    if (this.getType() != comparing.getType()) {
      return false;
    }

    // Same value
    return this.getValue() == comparing.getValue();
  }
}
