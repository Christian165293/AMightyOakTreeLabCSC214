package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {
    @Test
    void testNullSquirrelInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new TreeNode(null));
    }

    @Test
    void testSetSelfAsChild() {
        TreeNode node = new TreeNode(new Squirrel("Test"));
        assertThrows(IllegalArgumentException.class, () -> node.setLeft(node));
        assertThrows(IllegalArgumentException.class, () -> node.setRight(node));
    }

    @Test
    void testTraversals() {
        // Build a simple tree
        TreeNode root = new TreeNode(new Squirrel("1"));
        TreeNode left = new TreeNode(new Squirrel("2"));
        TreeNode right = new TreeNode(new Squirrel("3"));
        root.setLeft(left);
        root.setRight(right);

        // Test pre-order
        StringBuilder preOrder = new StringBuilder();
        root.preOrderTraversal(node -> preOrder.append(node.getSquirrel().getName()));
        assertEquals("123", preOrder.toString());
    }
}