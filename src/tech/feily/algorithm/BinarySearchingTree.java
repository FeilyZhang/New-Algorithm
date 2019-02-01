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
    
    private BinaryTreeNode search(BinaryTreeNode node, int data) {
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
    
    /*
     * emmm,利用parent节点的setLeft/RightChild()方法就可以实现插入操作
     */
    private BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        // 如果找不到结点了，也就是说父节点parent没有子节点了，那么即node == null
        // 那么就将data所代表的节点set到合适的位置
        if (node == null) {
            node = new BinaryTreeNode();
            node.setData(data);
            if (data > node.getData()) {
                parent.setRightChild(node);
            } else {
                parent.setLeftChild(node);
            }
            return node;
        // 如果父节点parent的子节点node的值与data相等，那么什么也不做，没意义，因为已经存在了
        } else if (node.getData() == data) {
            return node;
        // 否则选择合适的路径进行递归操作
        } else if (data > node.getData()) {
            return searchAndInsert(node, node.getRightChild(), data);
        } else {
            return searchAndInsert(node, node.getLeftChild(), data);
        }
    }
    
    public void insert(int data) {
        // 当没有根节点时，那么当前data所代表的结点就是根节点
        if (root == null) {
            root = new BinaryTreeNode();
            root.setData(data);
        } else {
            // 否则，从根节点开始搜索，根节点的父节点为null
            searchAndInsert(null, root, data);
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
        // Perform an insert operation.
        bst.insert(5);
        System.out.println("------------");
        bt.preOrder(bt.getRoot());
        System.out.println("------");
        bt.inOrder(bt.getRoot());
        System.out.println("------");
        bt.postOrder(bt.getRoot());
    }
}
