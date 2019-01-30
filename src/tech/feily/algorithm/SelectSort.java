package tech.feily.algorithm;

import java.util.Arrays;

/**
 * @author Administrator 
 * @date : 2019年1月30日下午2:33:39
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
            // 先假定本轮比较中索引i处的元素最小，那么最小元素的索引就是i
            int minIndex = i;
            // 先找到i + 1之后比i索引处元素更小的元素索引，赋值给minIndex
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[minIndex]) {   //此行的大于号改为小于号就是升序排序
                    minIndex = j;
                }
            }
            // 如果最小的元素索引不是i那么就有必要调换一下位置
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
