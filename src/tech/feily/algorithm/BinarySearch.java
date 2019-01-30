package tech.feily.algorithm;

/**
 * @author Administrator 
 * @date : 2019年1月30日下午7:47:45
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class BinarySearch {

    private int[] array;
    
    public BinarySearch(int[] array) {
        this.array = array;
    }
    
    public int search(int target, int start, int end) {
        QuickSort qs = new QuickSort(array);
        qs.sort();
        return binarySearch(target, start, end);
    }
    
    public int binarySearch(int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (target < array[mid]) {
            return binarySearch(target, start, mid - 1);
        } else {
            return binarySearch(target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {9, 6, 7, 8, 2, 3, 1, 1, 9};
        BinarySearch bs = new BinarySearch(arrays);
        System.out.println(bs.search(9, 0, arrays.length - 1));
    }
}
