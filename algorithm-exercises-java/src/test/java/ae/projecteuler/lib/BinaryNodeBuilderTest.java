package ae.projecteuler.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class BinaryNodeBuilderTest {

  private Integer[][] smallCaseData = {{75}, {95, 64}};

  @Test
  void instanceCaseTest() {
    BinaryNodeBuilder<Integer> classUnderTest = new BinaryNodeBuilder<Integer>();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        BinaryNodeBuilder.class,
        classUnderTest,
        String.format("Must be an instance of %s", BinaryNodeBuilder.class));
  }

  @Test
  void buildSmallTreeTest() {

    BinaryNodeBuilder<Integer> builder = new BinaryNodeBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTree(smallCaseData);

    assertEquals(75, testTree.getValue());
    assertEquals(95, testTree.getLeft().getValue());
    assertEquals(64, testTree.getRight().getValue());
  }

  @Test
  void buildNullTreeTest() {

    BinaryNodeBuilder<Integer> builder = new BinaryNodeBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTree(null);

    assertNull(testTree);
  }

  @Test
  void buildEmptyTreeTest() {
    Integer[][] emptyMatrix = {};

    BinaryNodeBuilder<Integer> builder = new BinaryNodeBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTree(emptyMatrix);

    assertNull(testTree);
  }

  @Test
  void buildMalformedMatrix1TreeTest() {
    Integer[][] emptyMatrix = {{1}, {2}, {3}};

    BinaryNodeBuilder<Integer> builder = new BinaryNodeBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTree(emptyMatrix);

    assertEquals(new BinaryNode<Integer>(1), testTree);
  }

  @Test
  void buildMalformedMatrix2TreeTest() {
    Integer[][] emptyMatrix = {{1}, {}, {3}};

    BinaryNodeBuilder<Integer> builder = new BinaryNodeBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTree(emptyMatrix);

    assertEquals(new BinaryNode<Integer>(1), testTree);
  }
}
