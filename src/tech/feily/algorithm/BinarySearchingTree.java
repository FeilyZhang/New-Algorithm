package tech.feily.algorithm;

/**
 * @author Administrator 
 * @date : 2019-2-1 7:59:02
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class BinarySearchingTree {
    
    private BinaryTreeNode root;
    
    public BinarySearchingTree(BinaryTreeNode root) {
        this.root = root;
    }
    
    public BinaryTreeNode search(int data) {
        return search(root, data);
    }
    
    public BinaryTreeNode search(BinaryTreeNode node, int data) {
        if (node == null) {
            return null;
        } else if (node.getData() == data) {
            return node;
        } else if (data > (Integer)node.getData()) {
            return search(node.getRightChild(), data);
        } else {
            return search(node.getLeftChild(), data);
        }
    }
    public static void main(String[] args) {
        // Initialize the binary search tree.
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode btn = new BinaryTreeNode();
        btn.setData(2);
        bt.setRoot(btn);
        BinaryTreeNode leftBtn = new BinaryTreeNode();
        leftBtn.setData(1);
        BinaryTreeNode rightBtn = new BinaryTreeNode();
        rightBtn.setData(3);
        bt.getRoot().setLeftChild(leftBtn);
        bt.getRoot().setRightChild(rightBtn);
        bt.preOrder(bt.getRoot());
        System.out.println("------");
        bt.inOrder(bt.getRoot());
        System.out.println("------");
        bt.postOrder(bt.getRoot());
        System.out.println("------------");
        // Perform a query operation.
        BinarySearchingTree bst = new BinarySearchingTree(bt.getRoot());
        System.out.println(bst.search(2).getData());
    }
}
