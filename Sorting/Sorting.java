package Sorting;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {

        int[] arr = { 7, 2, 4, 8, 9, 5, 3, 1, 6 };

        System.out.print(Arrays.toString(insertionSort(arr)));

    }

    // insertion sort
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        return arr;
    }

    // bubble sort always compare i and i+1 ele swap
    // for every iteration largest ele at end
    // tc is o(n^2) and sc is o(1).
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // if not swaped means right part is already sorted so
            // break and move to next iteration
            if (swapped == false)
                break;
        }
        return arr;
    }

    // selection sort select min in a range and place at ele at first
    // move the point next
    // // tc is o(n^2) and sc is o(1).
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int midIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[midIdx]) {
                    midIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[midIdx];
            arr[midIdx] = temp;
        }

        return arr;
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
