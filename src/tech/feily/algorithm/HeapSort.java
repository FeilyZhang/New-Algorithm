package tech.feily.algorithm;

/**
 * @author Administrator 
 * @date : 2019��2��2������12:27:20
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class HeapSort {

    private int[] elements;
    
    public HeapSort(int length) {
        elements = new int[length + 1];
        elements[0] = 0;
    }
    
    public boolean isEmpty() {
        return elements[0] == 0;
    }
    
    public boolean isFull() {
        return elements[0] == elements.length - 1;
    }
    
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("The big top heap is full.");
        }
        if (isEmpty()) {
            elements[1] = value;
        } else {
            int i = elements[0] + 1;    //ȷ������ĳ�ʼλ�ã�Ϊ������ȵ����һ���ڵ�
            // ��������Ԫ�ش��ڸ��ڵ㣬��ô�ý����ڵ��������ƣ�Ȼ��value����������λ��
            while (i != 1 && value > elements[i / 2]) {
                elements[i] = elements[i / 2];
                i /= 2;
            }
            // ���ս�ֵ���뵽ָ��λ��
            elements[i] = value;
        }
        elements[0] ++; //Ԫ�ظ�����һ
    }
    
    /*
     * emmm,��ӡ�ķ����ܼ򵥣���Ϊ����������ģ��ģ���ôֱ�ӱ������鼴��
     */
    public void printAll() {
        for (int i = 1; i < elements[0] + 1; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
    
    public int delete() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The big top heap is empty.");
        }
        int deleteElement = elements[1];    // Ҫɾ���Ľڵ㣬��ô���ڵ��Ϊ��
        elements[1] = elements[elements[0]];    // ������β����ֵ�滻�����ڵ�
        elements[0] --; // ���ȼ�һ����Ϊ���һ���ڵ��Ѿ�������Ϊ1��λ�ã������һ���ڵ��Ѿ��Ǹ��ڵ�
        // �������һ���ڵ�һ������²���������ԣ�����������������
        // ����ʱ������ڵ㣬��ΪҪ���������ԣ���ȡ�ķ��������ڲ���������û�����
        // Ҳ����˵���ջ�ճ���һ��λ�ã����λ�þ���temp�ڵ��λ�ã�ֱ�����ȥ����
        int temp = elements[1];
        int parent = 1;
        int child = 2;
        while (child <= elements[0]) {
            if (child < elements[0] && elements[child] < elements[child + 1]) {
                child ++;
            }
            if (temp > elements[child]) {
                break;
            } else {
                elements[parent] = elements[child];
                parent = child;
                child += 2;
            }
        }
        elements[parent] = temp;
        return deleteElement;
    }
    
    public void sort() {
        // ����Ҫ��ʼ��Ԫ��
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The big top heap is empty.");
        }
        // ����ɾ��Ԫ�أ�������������
        int size = elements[0];
        for (int i = 0; i < size; i++) {
            int deleteElement = delete();
            elements[elements[0] + 1] = deleteElement;
        }
        // ���������Ԫ��
        for (int i = 1; i < size + 1; i++) {
            System.out.print(elements[i]);
            if (i != size) {
                System.out.print(" ");
            }
        }
    }
    public static void main(String[] args) {
        HeapSort heap = new HeapSort(10);
        heap.insert(12);
        heap.insert(21);
        heap.insert(6);
        heap.insert(35);
        heap.insert(58);
        heap.insert(78);
        heap.insert(69);
        heap.insert(32);
        heap.insert(18);
        heap.insert(29);
        heap.printAll();
        heap.sort();
    }
}