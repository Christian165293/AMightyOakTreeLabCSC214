package org.example;

public class TreeNode {
    private final Squirrel squirrel;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public interface NodeAction {
        void execute(TreeNode node);
    }

    public TreeNode(Squirrel squirrel) {
        if (squirrel == null) {
            throw new IllegalArgumentException("Squirrel cannot be null");
        }
        this.squirrel = squirrel;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Squirrel getSquirrel() {
        return squirrel;
    }

    public TreeNode left() {
        return leftChild;
    }

    public TreeNode right() {
        return rightChild;
    }

    public void setLeft(TreeNode node) {
        if (this == node) {
            throw new IllegalArgumentException("Cannot set a node as its own child");
        }
        this.leftChild = node;
    }

    public void setRight(TreeNode node) {
        if (this == node) {
            throw new IllegalArgumentException("Cannot set a node as its own child");
        }
        this.rightChild = node;
    }

    public void preOrderTraversal(NodeAction action) {
        action.execute(this);
        if (leftChild != null) {
            leftChild.preOrderTraversal(action);
        }
        if (rightChild != null) {
            rightChild.preOrderTraversal(action);
        }
    }
}
