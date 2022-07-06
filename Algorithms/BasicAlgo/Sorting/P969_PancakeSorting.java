package BasicAlgo.Sorting;

import java.util.*;

public class P969_PancakeSorting {
    // n^2
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int largest = arr.length;
        while (largest > 0) {
            int index = findLargest(arr, largest);
            flip(arr, index);
            // 因为index是0-index，所以要加1
            res.add(index + 1);
            flip(arr, largest - 1);
            res.add(largest--);
        }
        return res;
    }

    private int findLargest(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private void flip(int[] arr, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
