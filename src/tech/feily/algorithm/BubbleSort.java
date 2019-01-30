package tech.feily.algorithm;

import java.util.Arrays;

/**
 * @author Administrator 
 * @date : 2019��1��30������2:59:40
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class BubbleSort {
    
    private int[] arrays;
    
    public BubbleSort(int[] arrays) {
        this.arrays = arrays;
    }
    
    public int[] sort() {
        // ð������ÿ�λὫĿ��Ԫ��ð�ݵ�����ͷ����Ҳ����˵����ͷ����������õ����ݣ������ٴβ���������ô�����ѭ��������
        // �ڲ�ѭ����ֱ�Ӳ������������
        for (int i = arrays.length - 1; i > 0; i--) {   
            for (int j = arrays.length - 1; j > arrays.length - 1 - i; j--) {
                if (arrays[j] > arrays[j - 1]) {    //�����еĴ��ںŸĳ�С�ں���ô������������
                    int temp = arrays[j - 1];
                    arrays[j - 1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        return arrays;
    }
    
    public static void main(String[] args) {
        int[] arrays = {9, 6, 7, 8, 2, 3, 1, 1, 9};
        System.out.println(Arrays.toString(new BubbleSort(arrays).sort()));
    }
}
