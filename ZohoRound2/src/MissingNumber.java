import java.util.Arrays;

public class MissingNumber {
    static void main() {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber2(nums));
    }


    // Brute Force Solution
    // TC = O(n Log n)  SC = O(n)
    public static int missingNumber(int[] nums) {
        int[] arr = mergeSort(nums, 0 , nums.length-1);

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (index != arr[i]) {
                return index;
            }
            index++;
        }

        return arr.length;
    }

    // Optimal Solution
    // TC = O(n)  SC = O(1)
    public static int missingNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];

            if (nums[i] < nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        int index = 0;
        for (int j = 0; j < nums.length; j++) {
            if (index != nums[j]) {
                return index;
            }
            index++;
        }

        return nums.length;
    }


    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return new int[]{arr[start]};
        }

        int mid = start + (end - start) / 2;

        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid + 1, end);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] merge = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merge[k++] = left[i++];
            } else {
                merge[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merge[k++] = left[i++];
        }

        while (j < right.length) {
            merge[k++] = right[j++];
        }

        return merge;
    }
}
