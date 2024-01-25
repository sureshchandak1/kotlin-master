package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PairSumArray {

    public static void main(String[] args) {
        int[] arr = new int[] {2, -3, 3, 3, -2};
        List<int[]> ans = pairSum(arr, 0);

        for (int[] value : ans) {
            System.out.println(Arrays.toString(value));
        }
    }

    private static List<int[]> pairSum(int[] arr, int s) {

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == s) {
                    int[] values = new int[2];
                    values[0] = Math.min(arr[i], arr[j]);
                    values[1] = Math.max(arr[i], arr[j]);
                    ans.add(values);
                }
            }
        }

        ans.sort((o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            return 0;
        });

        return ans;

    }

}
