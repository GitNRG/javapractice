package com.github.gitnrg.javapractice.dsa.mergesort;

import com.github.gitnrg.javapractice.dsa.mergesort.MergeSort;
import com.github.gitnrg.javapractice.dsa.mergesort.MergeSortImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortImplTest {
    private static MergeSort mergeSort;

    @BeforeAll
    static void beforeAll() {
        mergeSort = new MergeSortImpl(); // use your implementation here
    }

    @Test
    void testEmpty() {
        assertArrayEquals(new int[0], mergeSort.mergeSort(new int[0]));
    }

    @Test
    void testSingleValueArray() {
        assertArrayEquals(new int[]{1}, mergeSort.mergeSort(new int[]{1}));
    }

    @Test
    void testArrayWithTheSameValue() {
        assertArrayEquals(new int[]{3, 3, 3}, mergeSort.mergeSort(new int[]{3, 3, 3}));
    }


    @Test
    void testArrayOddNumberOfElements() {
        assertArrayEquals(new int[]{1, 2, 3}, mergeSort.mergeSort(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 2, 3}, mergeSort.mergeSort(new int[]{2, 3, 1}));
        assertArrayEquals(new int[]{1, 2, 3}, mergeSort.mergeSort(new int[]{3, 2, 1}));
    }

    @Test
    void testArrayEvenNumberOfElements() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, mergeSort.mergeSort(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, mergeSort.mergeSort(new int[]{2, 3, 4, 1}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, mergeSort.mergeSort(new int[]{3, 4, 2, 1}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, mergeSort.mergeSort(new int[]{4, 1, 3, 2}));
    }

}