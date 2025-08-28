package com.github.gitnrg.javapractice.dsa.mergesort;

import java.util.Arrays;

public class MergeSortImpl implements MergeSort {

    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        var left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        var right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                res[k] = left[i];
                i++;
            } else {
                res[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            res[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            res[k] = right[j];
            j++;
            k++;
        }
        return res;
    }
}
