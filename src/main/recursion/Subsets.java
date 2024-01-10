import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        findSubsets(3, new ArrayList<>());
    }

    private static void findSubsets(int n, ArrayList<Integer> subset) {

        if (n == 0) {
            printSubset(subset);
            return;
        }

        // add
        subset.add(n);
        findSubsets(n - 1, subset);

        // not add
        subset.remove(subset.size() - 1);
        findSubsets(n - 1, subset);
    }

    private static void printSubset(List<Integer> subset) {
        for (Integer integer : subset) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

}
