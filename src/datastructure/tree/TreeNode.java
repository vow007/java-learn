package datastructure.tree;


public class TreeNode {
    public TreeNode leftNode;
    public TreeNode rightNode;
    public Object data;

    public TreeNode(TreeNode leftNode, TreeNode rightNode, Object data) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.data = data;
    }

    public TreeNode(Object data) {
        this.data = data;
    }
}
