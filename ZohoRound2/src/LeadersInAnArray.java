import java.util.*;

public class LeadersInAnArray {
    static void main() {
        int[] nums = {16, 17, 4, 3, 5, 2};
        System.out.println(leadsInAnArray(nums));
    }

    public static List<Integer> leadsInAnArray(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int maxRight = arr[arr.length-1];

        for (int i = arr.length -2; i >= 0 ; i--) {
            if (arr[i] >= maxRight) {
                maxRight = arr[i];
                list.add(maxRight);
            }
        }

        Collections.reverse(list);
        list.add(arr[arr.length-1]);

        return list;
    }
}
