package tech.feily.algorithm;

import java.util.Arrays;

/**
 * @author Administrator 
 * @date : 2019年1月30日下午2:59:40
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
        // 冒泡排序每次会将目标元素冒泡到数组头部，也就是说数组头部都是排序好的数据，不必再次参与排序，那么用外层循环来控制
        // 内层循环是直接参与数组排序的
        for (int i = arrays.length - 1; i > 0; i--) {   
            for (int j = arrays.length - 1; j > arrays.length - 1 - i; j--) {
                if (arrays[j] > arrays[j - 1]) {    //将此行的大于号改成小于号那么就是升序排序
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
