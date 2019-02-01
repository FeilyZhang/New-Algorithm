package tech.feily.algorithm;

/**
 * @author Administrator 
 * @date : 2019��2��1������12:21:21
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class BinaryTreeNode {

    private int data;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    
    public void setData(int data) {
        this.data = data;
    }
    
    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    
    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public int getData() {
        return data;
    }
    
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }
    
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }
}
