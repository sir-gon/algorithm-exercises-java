package ae.projecteuler.lib;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class BinaryNodeWeightBuilderTest {

  private Integer[][] smallCaseData = {{75, 0}, {95, 64}};

  @Test
  void instanceCaseTest() {
    BinaryNodeBuilder<Integer> classUnderTest = new BinaryNodeWeightBuilder<Integer>();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        BinaryNodeWeightBuilder.class,
        classUnderTest,
        String.format("Must be an instance of %s", BinaryNodeWeightBuilder.class));
  }

  @Test
  void buildSmallTreeTest() {
    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTreeWithWeight(smallCaseData);

    assertEquals(75, testTree.getValue());
    assertEquals(75 + 95, testTree.getLeft().getValue());
    assertEquals(75 + 64, testTree.getRight().getValue());

    Integer[] expectedLeaves = {75 + 95, 75 + 64};

    assertArrayEquals(expectedLeaves, builder.getLeaves());
  }

  @Test
  void buildNullTreeTest() {

    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTreeWithWeight(null);

    assertNull(testTree);
  }

  @Test
  void buildEmptyTreeTest() {
    Integer[][] emptyMatrix = {};

    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTreeWithWeight(emptyMatrix);

    assertNull(testTree);
  }

  @Test
  void buildMalformedMatrix1TreeTest() {
    Integer[][] emptyMatrix = {{1}, {2}, {3}};

    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTreeWithWeight(emptyMatrix);

    assertEquals(new BinaryNode<Integer>(1), testTree);
  }

  @Test
  void buildMalformedMatrix2TreeTest() {
    Integer[][] emptyMatrix = {{1}, {}, {3}};

    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.buildBinaryNodeTreeWithWeight(emptyMatrix);

    assertEquals(new BinaryNode<Integer>(1), testTree);
  }
}
