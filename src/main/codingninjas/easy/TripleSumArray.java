package easy;

import java.util.ArrayList;

public class TripleSumArray {

    public static void main(String[] args) {
        int[] arr = new int[] {10, 5, 5, 5, 2};
        ArrayList<ArrayList<Integer>> ans = findTriplets(arr, arr.length, 12);
        System.out.println(ans);
    }

    private static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean isFound = false;
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == K) {
                        ArrayList<Integer> values = new ArrayList<>();
                        values.add(arr[i]);
                        values.add(arr[j]);
                        values.add(arr[k]);
                        ans.add(values);
                        isFound = true;
                        break;
                    }
                }

                if (isFound) {
                    break;
                }
            }

            if (isFound) {
                break;
            }
        }

        return ans;

    }

}
