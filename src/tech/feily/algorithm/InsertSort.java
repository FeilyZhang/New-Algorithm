package tech.feily.algorithm;

import java.util.Arrays;

/**
 * @author Administrator 
 * @date : 2019��1��30������4:13:45
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class InsertSort {

    private int[] arrays;
    
    public InsertSort(int[] arrays) {
        this.arrays = arrays;
    }
    
    public int[] sort() {
        for (int i = 1; i < arrays.length; i++) {
            int temp = arrays[i];   //�������Ԫ��
            int j = i;
            // jλ�õ�Ԫ����֮ǰ��ȫ�����αȽϣ��Բ��뵽���ʵ�λ��
            // arrays[j - 1] > temp�еĴ��ںű��С�ںž��ǽ�������
            for (; j > 0 && arrays[j - 1] > temp; j--) {   // j����0����ΪjҪ��һ����ֹ�±�Խ��
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = temp;
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] arrays = {9, 6, 7, 8, 2, 3, 1, 1, 9};
        System.out.println(Arrays.toString(new InsertSort(arrays).sort()));
    }
}
