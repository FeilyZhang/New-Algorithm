package tech.feily.algorithm;

import java.util.Arrays;

/**
 * @author Administrator 
 * @date : 2019��1��30������1:07:49
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class BucketSort {

    private int[] buckets;
    private int[] arrays;
    
    public BucketSort(int range, int[] arrays) {
        this.buckets = new int[range];
        this.arrays = arrays;
    }
    
    public void sort() {
        if (arrays != null && arrays.length > 1) {
            // ����arrays��Ȼ��ѡ����Ӧ��Ͱ�Ž�ȥ
            for (int array : arrays) {
                buckets[array]++;
            }
        }
    }
    
    /*
     * emmm,�÷�����������������
     */
    public int[] getResult() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                if ((i == (buckets.length - 1)) && (j == (buckets[i] - 1))) {
                    sb.append(i);
                } else {
                    sb.append(i);
                    sb.append(',');
                }
            }
        }
        String[] str = sb.toString().split(",");
        int[] result = new int[str.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(str[i]);
        }
        return result;
    }
    
    /*
     * emmm,�÷����������������������ֱ�Ӵ�ӡ
     */
    public void printAll() {
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arrays = {9, 6, 7, 8, 2, 3, 1, 1, 9};
        BucketSort sort = new BucketSort(10, arrays);
        sort.sort();
        int[] result = sort.getResult();
        System.out.println(Arrays.toString(result));
        sort.printAll();
    }
}
