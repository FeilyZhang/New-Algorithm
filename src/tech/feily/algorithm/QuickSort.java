package tech.feily.algorithm;

/**
 * @author Administrator 
 * @date : 2019年1月30日下午6:21:24
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
            int base = arrays[begin];   //基准
            int left = begin;   //左哨兵
            int right = end;  //右哨兵
            // 当left与right没相遇时就执行该循环
            // 即right先找到比基准小的然后停止，left找到比基准大的然后停止，交换二者，然后继续重复，直至相遇，即left == right
            while (left != right) {
                // 如果没找到就继续寻找
                while (left < right && arrays[right] >= base) {
                    right --;
                }
                // 如果执行到这里那么说明哨兵right已经找到比base小的了
                // 接下来left哨兵寻找比base大的
                while (left < right && arrays[left] <= base) {
                    left ++;
                }
                // 如果执行到这里那么说明哨兵left已经找到比base大的了
                // 由于哨兵right和left都已经找到了目标元素，那么交换位置
                if (left < right) {
                    // 不用中间变量交换两个元素位置
                    arrays[left] = arrays[left] + arrays[right];
                    arrays[right] = arrays[left] - arrays[right];
                    arrays[left] = arrays[left] - arrays[right];
                }
            }
            // 既然已经跳出了while循环，那么说明哨兵right与left已经相遇，那么就需要交换相遇位置处的元素与基准
            // 从而使得基准左边小于基准，右边大于基准
            arrays[begin] = arrays[left];  // 或者arrays[0] = arrays[right]也一样
            arrays[left] = base;    // 或者arrays[right] = base也一样
            // 然后对左右两部分再进行递归处理
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
