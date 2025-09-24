package com.github.gitnrg.javapractice.quicksort;

public class QuicksortImpl implements Quicksort {

    public void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // put pivot in the final place
        int pivotIdx = i + 1;
        int temp = arr[pivotIdx];
        arr[pivotIdx] = pivot;
        arr[high] = temp;

        quicksort(arr, low, pivotIdx - 1);
        quicksort(arr, pivotIdx + 1, high);
    }
}
