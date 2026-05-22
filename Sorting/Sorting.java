package Sorting;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {

        int[] arr = { 7, 2, 4, 8, 9, 5, 3, 1, 6 };

        System.out.print(Arrays.toString(quickSort(arr)));

    }

    public static int[] quickSort(int[] array) {
        qS(array, 0, array.length - 1);
        return array;
    }

    private static void qS(int[] array, int low, int high) {

        if (low < high) {

            int pIndex = partition(array, low, high);
            qS(array, low, pIndex - 1); // left arr
            qS(array, pIndex + 1, high); // right arr
        }
    }

    private static int partition(int[] array, int low, int high) {

        // arr fst ele as pivot
        int pivot = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            // finding next element > pivot stops at greater ele
            while (array[i] <= pivot && i <= high - 1) {
                i++;
            }
            // finding next element <= pivot stops at smaller ele
            while (array[j] > pivot && j >= low + 1) {
                j--;
            }
            // swapping small to left and large to right
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swapping low pivot to crt place
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j; // partition ele
    }

    // merge sort
    // tc is o(n log n) sc is o(n log n)
    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        ms(arr, 0, n - 1);
        return arr;
    }

    private static void ms(int[] arr, int low, int high) {

        if (low == high)
            return;
        int mid = (low + high) / 2;
        ms(arr, low, mid);
        ms(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {

            if (arr[left] < arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }

        }

        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
    }

}
