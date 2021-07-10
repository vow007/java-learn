package algorithm.sort.merge;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。
 java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。从上文的图中可看出，
 每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)。
 而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
 https://www.cnblogs.com/chengxiao/p/6194356.html
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
//        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] tempArr = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tempArr);
        //Arrays.stream(arr).forEach(System.out::println);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        //把较小的数先移到新数组中
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }
        //将左边剩余放入新数组
        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }

        //将右边边剩余放入新数组
        while (j <= right) {
            tempArr[k++] = arr[j++];
        }
//        //将temp中的元素全部拷贝到原数组中
        for (int t = 0; left <= right; ) {
            arr[left++] = tempArr[t++];
        }
        //IntStream.range(0, k).forEachOrdered(t -> arr[t + left] = tempArr[t]);

    }

    public static void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left < right) {
            int mid = (left + right) >> 1;
            //对左侧归并排序（"分"），使得左子序列有序
            mergeSort(arr, left, mid, tempArr);
            //对右侧归并排序（"分"），使得右子序列有序
            mergeSort(arr, mid + 1, right, tempArr);
            //将两个有序子数组合并操作（"治"）
            merge(arr, left, mid, right, tempArr);
        }
    }

}