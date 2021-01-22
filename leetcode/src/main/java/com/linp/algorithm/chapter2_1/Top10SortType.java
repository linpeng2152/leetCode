package com.linp.algorithm.chapter2_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : linpeng
 * ON 2020-09-15
 * used for:
 * <p>
 * 十大经典排序
 * <p>
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 */
public class Top10SortType {


    public static void main(String[] args) {

        int[] arr = {11, 20, 10, 13, 2, 3, 5, 1, 21, 4, 135, 6, 9, 7};

        //冒泡排序
//        bubbleSort(arr);

        //选择排序
//        selectionSort(arr);

        //插入排序
//        insertionSort(arr);

        //希尔排序
//        shellSort(arr);
//        shellSort2(arr);

        //归并排序
//        List<Integer> a = Arrays.asList(11,20,10,13,2, 3, 5, 1, 4, 6, 9, 7);
//        List<Integer> aa =  mergeSort(a);

        //计算排序
//        countSort(arr);

        //桶排序
//        bucketSort(arr,10);

        //基数排序
//        radixSort(arr);

        //快速排序
        arr = qsort(arr,0,args.length-1);



        SortBase.print(qsort(arr,0,args.length-1));


    }

    /**
     * 1、冒泡排序
     * <p>
     * <p>
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
     * 如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
     * 也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * 描述
     * <p>
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;

        //循环N次
        for (int i = 0; i < len; i++) {
            //循环N次
            for (int j = 0; j < len - i - 1; j++) {
                //假如 前面一个 比 后面一个比 大 则交换位置
                if (!SortBase.less(arr[j], arr[j + 1])) {
                    SortBase.exch(arr, j, j + 1);
                }
            }
        }
    }


    /**
     * 2、选择排序
     * <p>
     * 选择排序(Selection-sort)是一种简单直观的排序算法。
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕
     * <p>
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
     * 使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     */
    public static void selectionSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (!SortBase.less(arr[minIndex], arr[j])) {
                    minIndex = j;
                }
            }

            SortBase.exch(arr, minIndex, i);


        }


    }

    /**
     * 3、插入排序
     * <p>
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，
     * 在已排序序列中从后向前扫描，找到相应位置并插入。
     * <p>
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     */
    public static void insertionSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int temp = i;
            for (int j = i; j >= 0; j--) {
                if (SortBase.less(arr[temp], arr[j])) {
                    SortBase.exch(arr, temp, j);
                    temp = j;
                }
            }
        }

    }

    /**
     * 4、希尔算法  时间复杂度 nlogn ～ n^2   评价时间复杂度 n^1.3
     * <p>
     * 是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序
     * <p>
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     * <p>
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    public static void shellSort(int[] array) {
        System.out.println("排序之前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        //希尔排序
        int gap = array.length;
        while (true) {
            gap /= 2;   //增量每次减半
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }
            if (gap == 1)
                break;
        }

        System.out.println();
        System.out.println("排序之后：");

    }


    public static void shellSort2(int[] arr) {
        int len = arr.length;
        int h = len;
        while (true) {
            h = h / 3;

            for (int i = 0; i < h; i++) {
                for (int j = i + h; j < len; j += h) {
                    int temp = arr[j];
                    int k = j - h;
                    while (k >= 0 && arr[k] > temp) {
                        arr[k + h] = arr[k];
                        k = k - h;
                    }
                    arr[k + h] = temp;
                }
            }
            if (h == 1) {
                break;
            }
        }
    }


    /**
     * 5、归并排序  使用递归
     * <p>
     * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
     * <p>
     * 5.1 算法描述
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     */
    public static List<Integer> mergeSort(List<Integer> arr) {
        int len = arr.size();
        if (len < 2) {
            return arr;
        }
        int mid = len / 2;
        List<Integer> left = new ArrayList<>(arr.subList(0, mid));
        List<Integer> right = new ArrayList<>(arr.subList(mid, len));

        return merge(mergeSort(left), mergeSort(right));

    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();

        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0) <= right.get(0)) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }
        if (left.size() > 0) {
            result.addAll(left);
        }
        if (right.size() > 0) {
            result.addAll(right);
        }

        return result;

    }


    /**
     * 6、计数排序
     * <p>
     * 算法描述
     * 找出待排序的数组中最大和最小的元素；
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     */
    public static void countSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        if (max == min) {
            return;
        }
        int[] temp = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            int t = arr[i] - min;
            temp[t] = temp[t] + 1;
        }
        int i = 0;
        int y = 0;
        while (i <= max - min) {
            int t = temp[i];
            if (t == 0) {
                i++;
            } else {
                arr[y] = min + i;
                y++;
                temp[i] = temp[i] - 1;
                if (temp[i] <= 0) {
                    i++;
                }
            }
        }


    }

    /**
     * 7、桶排序
     * <p>
     * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
     * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
     * <p>
     * 设置一个定量的数组当作空桶；
     * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
     * 对每个不是空的桶进行排序；
     * 从不是空的桶里把排好序的数据拼接起来。
     */

    public static void bucketSort(int[] arr, int bucketSize) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }


        List<Integer>[] bucket = new List[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < arr.length; i++) {
            int item = (arr[i] - min) / bucketSize;
            bucket[item].add(arr[i]);
        }

        int[] item;
        int x = 0;
        for (int i = 0; i < bucketSize; i++) {
            item = sortItem(bucket[i]);
            for (int j = 0; j < item.length; j++) {
                arr[x] = item[j];
                x++;
            }
        }
    }

    public static int[] sortItem(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
//        bubbleSort(arr);
        return arr;
    }

    /**
     * 8、基数排序
     * <p>
     * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     * 有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
     * <p>
     * 取得数组中的最大数，并取得位数；
     * arr为原始数组，从最低位开始取每个位组成radix数组；
     * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     */
    public static void radixSort(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int len = ("" + max).length();
        for (int i = 0; i < len; i++) {
            radixSortItem(arr, i);
        }

    }

    public static void radixSortItem(int[] curArr, int index) {

        List<Integer>[] bucket = new List[10];
        for (int i = 0; i < 10; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < curArr.length; i++) {
            int item = radixSortItem2(curArr[i], index);
            bucket[item].add(curArr[i]);
        }
        int[] item;
        int x = 0;
        for (int i = 0; i < 10; i++) {
            item = sortItem(bucket[i]);
            for (int j = 0; j < item.length; j++) {
                curArr[x] = item[j];
                x++;
            }
        }

    }

    //获取第N位的数目
    public static int radixSortItem2(int value, int i) {
        return (int) (value % Math.pow(10, i + 1) / Math.pow(10, i));
    }


    public static int[] qsort(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) arr=qsort(arr,start,i-1);
        if (j+1<end) arr=qsort(arr,j+1,end);
        return (arr);
    }


}
