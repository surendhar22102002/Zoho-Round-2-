import java.util.Arrays;

public class AlternateSorting {
    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(solution1(arr)));
    }


    // Optimal Solution
    // TC = O(n log n)  SC = O(n)
    public static int[] solution1(int[] arr) {
       int[] nums = mergeSort(arr, 0, arr.length-1);

       int start = 0;
       int end = arr.length-1;
       int index = 0;

       int[] result = new int[arr.length];

       while (start <= end) {
           result[index++] = nums[end--];
           if (start <= end) {
               result[index++] = nums[start++];
           }
       }


       return result;
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return new int[]{arr[start]};
        }

        int mid = start + (end - start) / 2;

        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid+1, end);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }

        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }
}
