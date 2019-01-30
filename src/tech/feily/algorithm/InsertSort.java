package tech.feily.algorithm;

import java.util.Arrays;

/**
 * @author Administrator 
 * @date : 2019年1月30日下午4:13:45
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
            int temp = arrays[i];   //待插入的元素
            int j = i;
            // j位置的元素与之前的全部依次比较，以插入到合适的位置
            // arrays[j - 1] > temp中的大于号变成小于号就是降序排序
            for (; j > 0 && arrays[j - 1] > temp; j--) {   // j大于0是因为j要减一，防止下标越界
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
