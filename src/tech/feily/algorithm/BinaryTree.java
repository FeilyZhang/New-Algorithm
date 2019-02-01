package tech.feily.algorithm;

/**
 * @author Administrator 
 * @date : 2019��2��1������12:26:34
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class BinaryTree {

    private BinaryTreeNode root;
    
    public BinaryTree() {
        
    }
    
    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }
    
    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
    
    public BinaryTreeNode getRoot() {
        return root;
    }
    
    /*
     * emmm,���ĳ�����������нڵ�
     */
    public void clear(BinaryTreeNode node) {
        if (node != null) {
            clear(node.getLeftChild()); //�ݹ��ɾ�����ӽڵ�
            clear(node.getRightChild());    //�ݹ��ɾ�����ӽڵ�
            node = null;    //ɾ���ڵ�
        }
    }
    
    /*
     * emmm,�����
     */
    public void clear() {
        clear(root);
    }
    
    /*
     * emmm,�ж϶������Ƿ�Ϊ�գ���ôֻ��Ҫ�ж϶��������ڵ��Ƿ�Ϊnull����
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /*
     * emmm,��ȡ�������ĸ߶�
     */
    public int height() {
        return height(root);
    }
    
    /*
     * emmm,��ȡĳ�ڵ�Ϊ�����ĸ߶�
     */
    public int height(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = height(node.getLeftChild()); // �ݹ�Ļ�ȡ�������ĸ߶�
            int right = height(node.getRightChild());    // �ݹ�Ļ�ȡ�������ĸ߶�
            // �߶�Ӧ������ߵ�һ�ߣ���1����ΪҪ�����Լ���һ��
            return left < right ? right + 1 : left + 1; //��������ִ���������
        }
    }
    
    /*
     * emmm,��ȡ�������Ľڵ���
     */
    public int size() {
        return size(root);
    }
    
    /*
     * emmm,��ȡĳ�ڵ�Ϊ�����Ľڵ���
     */
    public int size(BinaryTreeNode node) {
        // ������Ϊ�գ���ôֱ�ӷ���0
        if (node == null) {
            return 0;
        } else {
            // ����ݹ�Ļ�ȡ�������Ľڵ������������Ľڵ��������
            // ��1����ΪҪ���㱾�ڵ�
            return 1 + size(node.getLeftChild()) + size(node.getRightChild());
        }
    }
    
    /*
     * emmm,���ҽ���������������еĸ��ڵ㣬���Ը��ڵ�Ϊ���������������
     */
    public BinaryTreeNode getParent(BinaryTreeNode node) {
        // ���ڵ�û�и��ڵ㣬ֱ�ӷ���null
        return (root == null || root == node) ? null : getParent(root, node);
    }
    
    /*
     * emmm,�ݹ����node�����subTree�����еĸ��ڵ�
     */
    public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
        // �������subTreeΪ�գ���ô�ڵ�nodeû�и��ڵ�
        if (subTree == null) {
            return null;
        }
        // ������������ӽڵ�����Һ��ӽڵ���node����ôֱ�ӷ�������(��һ���ڵ����)
        // ʵ���ϣ�����ж��������������жϴ���
        if (subTree.getLeftChild() == node || subTree.getRightChild() == node) {
            return subTree;
        }
        BinaryTreeNode parent = null;
        // ��Ϊnode�ڵ�������subTree�еĸ��ڵ��п������������ϣ�Ҳ�п������������ϣ���ô��Ҫ�����ж�
        // ���������������ôֱ�ӷ���parent
        if ((parent = getParent(subTree.getLeftChild(), node)) != null) {
            return parent;
        } else {
            // ����ݹ�������
            return getParent(subTree.getRightChild(), node);
        }
    }
    
    /*
     * emmm,��ȡĳ���ڵ��������������ֱ�ӷ��ظýڵ������
     */
    public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
        return node.getLeftChild();
    }
    
    /*
     * emmm,��ȡĳ���ڵ��������������ֱ�ӷ��ظýڵ���Һ���
     */
    public BinaryTreeNode getRightTree(BinaryTreeNode node) {
        return node.getRightChild();
    }
    
    /*
     * emmm,�������������
     * emmm,ֱ���ø��ڵ���������Ϊ���node������ø��ڵ�parent�Ѿ���������ô�ò����Ḳ��ԭ�ȵĺ��ӽڵ�
     */
    public void insertLeft(BinaryTreeNode parent, BinaryTreeNode node) {
        parent.setLeftChild(node);
    }

    /*
     * emmm,���������Ҳ���
     * emmm,ֱ���ø��ڵ������Һ���Ϊ���node������ø��ڵ�parent�Ѿ����Һ�����ô�ò����Ḳ��ԭ�ȵĺ��ӽڵ�
     */
    public void insertRight(BinaryTreeNode parent, BinaryTreeNode node) {
        parent.setRightChild(node);
    }
    
    /*
     * emmm,�����������������
     */
    public void visited(BinaryTreeNode node) {
        System.out.println(node.getData());
    }
    
    /*
     * emmm,�ȸ�������˳������
     * 1. ���ʸ��ڵ�,���ȸ�
     * 2. �ȸ�����������
     * 3. �ȸ�����������
     * 4. �˳�
     */
    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            visited(node);  // �ȷ��ʸ��ڵ�
            preOrder(node.getLeftChild());  //�ٱ���������
            preOrder(node.getRightChild()); //�ٱ���������
        }   // �˳�
    }
    
    /*
     * emmm,�и�������˳������
     * 1. �и�����������
     * 2. ���ʸ��ڵ�
     * 3. �и�����������
     * 4. �˳�
     */
    public void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.getLeftChild());   // �и�����������
            visited(node);  // ���ʸ��ڵ�
            inOrder(node.getRightChild());  // �и�����������
        }   // �˳�
    }
    
    /*
     * emmm,�и�������˳������
     * 1. �������������
     * 2. �������������
     * 3. ���ʸ��ڵ�
     * 4. �˳�
     */
    public void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.getLeftChild()); // �������������
            postOrder(node.getRightChild());    // �������������
            visited(node);  //���ʸ��ڵ�
        }   //�˳�
    }
    /*
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode btn = new BinaryTreeNode();
        btn.setData(0);
        bt.setRoot(btn);
        BinaryTreeNode leftBtn = new BinaryTreeNode();
        leftBtn.setData(1);
        BinaryTreeNode rightBtn = new BinaryTreeNode();
        rightBtn.setData(2);
        bt.getRoot().setLeftChild(leftBtn);
        bt.getRoot().setRightChild(rightBtn);
        bt.preOrder(bt.getRoot());
        System.out.println("------");
        bt.inOrder(bt.getRoot());
        System.out.println("------");
        bt.postOrder(bt.getRoot());
    }*/
}
