package projecteuler.lib;

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

  private Integer[][] smallCaseData = {
    {75, 0},
    {95, 64}
  };

  @Test void instanceCaseTest() {
    BinaryNodeBuilder<Integer> classUnderTest = new BinaryNodeWeightBuilder<Integer>();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        BinaryNodeWeightBuilder.class,
        classUnderTest,
        String.format("Must be an instance of %s", BinaryNodeWeightBuilder.class));
  }

  @Test void buildSmallTreeTest() {
    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.build_binary_node_tree_with_weight(smallCaseData);

    assertEquals(75, testTree.getValue());
    assertEquals(75 + 95, testTree.getLeft().getValue());
    assertEquals(75 + 64, testTree.getRight().getValue());

    Integer[] expectedLeaves =  {75 + 95, 75 + 64};

    assertArrayEquals(expectedLeaves, builder.getLeaves());
  }

  @Test void buildNullTreeTest() {

    BinaryNodeWeightBuilder<Integer> builder = new BinaryNodeWeightBuilder<Integer>();
    BinaryNode<Integer> testTree = builder.build_binary_node_tree_with_weight(null);

    assertNull(testTree);
  }
}
