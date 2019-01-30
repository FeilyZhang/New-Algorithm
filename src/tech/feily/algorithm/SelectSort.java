package tech.feily.algorithm;

import java.util.Arrays;

/**
 * @author Administrator 
 * @date : 2019��1��30������2:33:39
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class SelectSort {

    private int[] array;
    
    public SelectSort(int[] array) {
        this.array = array;
    }
    
    public int[] sort() {
        for (int i = 0; i < array.length - 1; i++) {
            // �ȼٶ����ֱȽ�������i����Ԫ����С����ô��СԪ�ص���������i
            int minIndex = i;
            // ���ҵ�i + 1֮���i������Ԫ�ظ�С��Ԫ����������ֵ��minIndex
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[minIndex]) {   //���еĴ��ںŸ�ΪС�ںž�����������
                    minIndex = j;
                }
            }
            // �����С��Ԫ����������i��ô���б�Ҫ����һ��λ��
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arrays = {9, 6, 7, 8, 2, 3, 1, 1, 9};
        System.out.println(Arrays.toString(new SelectSort(arrays).sort()));
    }
}
