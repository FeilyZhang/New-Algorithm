# New-Algorithm
Java implementation of common algorithms.
---
### 桶排序
+ 思路：以待排序的数组中的最大值为长度，新建一个桶数组，然后遍历待排序数组，将遍历到的元素值放入桶数组的对应索引处然后该索引处元素值自增1代表该处有一个元素，如果为2，那么就说明该处有两个相同的元素。最后遍历桶数组依次输出桶数组的索引，该索引处元素值为几那么就连续输出几次代表重复元素。
+ 特点：借助于数组快速检索的特点，桶排序具有快速和简单的特点；但是当待排序数组中的最大值非常大时那么桶排序性能很低，因为空间不一定被占满会浪费，即如果数据跨度大那么空间利用率低。
+ 适用场景：适用于数据分布均匀、跨度小的场景。
+ 时间复杂度：O(n + m)，其中n是待排序的元素个数，m为桶的个数，如果仅仅对元素排序不输出那么时间复杂度就是O(n)，如果排序还输出那么就是O(n + m)，因为排序需要遍历一次待排序数组，即n，输出需要遍历桶数组，即m
+ 空间复杂度：O(m)，其中m为桶的个数，由待排序数组中的最大值确定
---
### 选择排序
+ 思路：以从小到大排序为例，从待排序数组的头部开始，假定当前元素为最小值，然后再在内层循环中找其余元素中比当前假定的最小元素更小的最小值，如果找到就交换位置，那么这样依次下去，就会排序完成。
+ 特点：选择法排序是一种不稳定的排序。举个例子，数列5 7 5 2中，第一个元素5和第四个元素2必然会交换次序，那么第三个元素5与原来第一个元素5的次序就发生了变化，即前后顺序被破坏了，所以该排序是不稳定的。
+ 适用场景：该排序不太常用。
+ 时间复杂度：O(n^2),因为有两个步长为1的for循环
+ 空间复杂度：O(1),因为我们的排序是在原数组之上进行了，即使交换两个元素那么也只需要一个常量级空间，甚至不需要临时变量也可以实现元素交换
---
### 冒泡排序
+ 思路：将一个数组的头部向上，尾部向下，那么就相当于一个水池了。每次将目标元素冒泡到数组头部，那么经过几轮比较之后就会形成排序之后的结果。至于目标元素的选择方法，以从大到小排序为例，每次从数组底部开始选择相邻的两个元素进行比较，然后将较大的元素冒上去。
+ 特点：冒泡排序是稳定的。因为在比较过程中，只有后一个元素比前一个元素大时才会交换它们的位置，对于同样大小的元素，是不需要交换位置的，所以对于同样大小的元素来说，它们的位置不会发生变化。
+ 适用场景：不太常用
+ 时间复杂度：最坏情况下为O(n^2)，最好情况下为O(n)，平均时间复杂度为O(n^2)
+ 空间复杂度：O(1)，因为也是在原数组上进行处理，元素之间的交换也可以不用中间临时变量
