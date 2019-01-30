package tech.feily.algorithm;

/**
 * @author Administrator 
 * @date : 2019��1��30������6:21:24
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class QuickSort {

    private int[] array;
    
    public QuickSort(int[] array) {
        this.array = array;
    }
    
    public void sort() {
        sort(array, 0, array.length - 1);
    }
    
    public void printAll() {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
    public void sort(int[] arrays,int begin, int end) {
        if (begin < end) {
            int base = arrays[begin];   //��׼
            int left = begin;   //���ڱ�
            int right = end;  //���ڱ�
            // ��left��rightû����ʱ��ִ�и�ѭ��
            // ��right���ҵ��Ȼ�׼С��Ȼ��ֹͣ��left�ҵ��Ȼ�׼���Ȼ��ֹͣ���������ߣ�Ȼ������ظ���ֱ����������left == right
            while (left != right) {
                // ���û�ҵ��ͼ���Ѱ��
                while (left < right && arrays[right] >= base) {
                    right --;
                }
                // ���ִ�е�������ô˵���ڱ�right�Ѿ��ҵ���baseС����
                // ������left�ڱ�Ѱ�ұ�base���
                while (left < right && arrays[left] <= base) {
                    left ++;
                }
                // ���ִ�е�������ô˵���ڱ�left�Ѿ��ҵ���base�����
                // �����ڱ�right��left���Ѿ��ҵ���Ŀ��Ԫ�أ���ô����λ��
                if (left < right) {
                    // �����м������������Ԫ��λ��
                    arrays[left] = arrays[left] + arrays[right];
                    arrays[right] = arrays[left] - arrays[right];
                    arrays[left] = arrays[left] - arrays[right];
                }
            }
            // ��Ȼ�Ѿ�������whileѭ������ô˵���ڱ�right��left�Ѿ���������ô����Ҫ��������λ�ô���Ԫ�����׼
            // �Ӷ�ʹ�û�׼���С�ڻ�׼���ұߴ��ڻ�׼
            arrays[begin] = arrays[left];  // ����arrays[0] = arrays[right]Ҳһ��
            arrays[left] = base;    // ����arrays[right] = baseҲһ��
            // Ȼ��������������ٽ��еݹ鴦��
            sort(arrays, begin, left - 1);
            sort(arrays, right + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {9, 6, 7, 8, 2, 3, 1, 1, 9};
        QuickSort st = new QuickSort(arrays);
        st.sort();
        st.printAll();
    }
}
