package algorithm.sort.quick;


/*快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

算法描述
        快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

        从数列中挑出一个元素，称为 “基准”（pivot）；
        重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
        递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
        */

/*
快速排序之所比较快，因为相比冒泡排序，每次交换是跳跃式的。
每次排序的时候设置一个基准点，将小于等于基准点的数全部放到基准点的左边，将大于等于基准点的数全部放到基准点的右边。
这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，交换的距离就大的多了。
因此总的比较和交换次数就少了，速度自然就提高了。当然在最坏的情况下，仍可能是相邻的两个数进行了交换。
因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)。
其实快速排序是基于一种叫做“二分”的思想。我们后面还会遇到“二分”思想，到时候再聊。先上代码，如下
https://www.cnblogs.com/onepixel/p/7674659.html
*/

public class QuickSort {

    static void quicksort(int arr[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(arr, left, right);
            quicksort(arr, left, dp - 1);
            quicksort(arr, dp + 1, right);
        }
    }

    static int partition(int arr[], int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            //首先哨兵right开始出动。因为此处设置的基准数是最左边的数，所以需要让哨兵right先出动，这一点非常重要
            //https://blog.csdn.net/u014241071/article/details/81565148
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            //左边右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
            arr[left] = pivot;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quicksort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
