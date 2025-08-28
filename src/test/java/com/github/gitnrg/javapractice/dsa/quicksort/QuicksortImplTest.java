package com.github.gitnrg.javapractice.dsa.quicksort;

import com.github.gitnrg.javapractice.dsa.quicksort.Quicksort;
import com.github.gitnrg.javapractice.dsa.quicksort.QuicksortImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuicksortImplTest {
    private static Quicksort quicksort;

    @BeforeAll
    static void beforeAll() {
        quicksort = new QuicksortImpl(); // use your implementation here
    }

    @Test
    void testEmpty() {
        int[] arr = new int[0];

        quicksort.quicksort(arr);

        assertArrayEquals(new int[0], arr);
    }

    @Test
    void testSingleValueArray() {
        int[] arr = new int[]{1};

        quicksort.quicksort(arr);

        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    void testArrayWithTheSameValue() {
        int[] arr = new int[]{3, 3, 3};

        quicksort.quicksort(arr);

        assertArrayEquals(new int[]{3, 3, 3}, arr);
    }


    @Test
    void testArrayOddNumberOfElements() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{2, 3, 1};
        int[] arr3 = new int[]{3, 2, 1};

        quicksort.quicksort(arr1);
        quicksort.quicksort(arr2);
        quicksort.quicksort(arr3);

        assertArrayEquals(new int[]{1, 2, 3}, arr1);
        assertArrayEquals(new int[]{1, 2, 3}, arr2);
        assertArrayEquals(new int[]{1, 2, 3}, arr3);
    }

    @Test
    void testArrayEvenNumberOfElements() {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{2, 3, 4, 1};
        int[] arr3 = new int[]{3, 4, 2, 1};
        int[] arr4 = new int[]{4, 1, 3, 2};

        quicksort.quicksort(arr1);
        quicksort.quicksort(arr2);
        quicksort.quicksort(arr3);
        quicksort.quicksort(arr4);

        assertArrayEquals(new int[]{1, 2, 3, 4}, arr1);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr2);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr3);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr4);
    }
}