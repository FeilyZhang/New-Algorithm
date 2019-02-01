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
     * emmm,����parent�ڵ��setLeft/RightChild()�����Ϳ���ʵ�ֲ������
     */
    private BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        // ����Ҳ�������ˣ�Ҳ����˵���ڵ�parentû���ӽڵ��ˣ���ô��node == null
        // ��ô�ͽ�data������Ľڵ�set�����ʵ�λ��
        if (node == null) {
            node = new BinaryTreeNode();
            node.setData(data);
            if (data > node.getData()) {
                parent.setRightChild(node);
            } else {
                parent.setLeftChild(node);
            }
            return node;
        // ������ڵ�parent���ӽڵ�node��ֵ��data��ȣ���ôʲôҲ������û���壬��Ϊ�Ѿ�������
        } else if (node.getData() == data) {
            return node;
        // ����ѡ����ʵ�·�����еݹ����
        } else if (data > node.getData()) {
            return searchAndInsert(node, node.getRightChild(), data);
        } else {
            return searchAndInsert(node, node.getLeftChild(), data);
        }
    }
    
    public void insert(int data) {
        // ��û�и��ڵ�ʱ����ô��ǰdata������Ľ����Ǹ��ڵ�
        if (root == null) {
            root = new BinaryTreeNode();
            root.setData(data);
        } else {
            // ���򣬴Ӹ��ڵ㿪ʼ���������ڵ�ĸ��ڵ�Ϊnull
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
