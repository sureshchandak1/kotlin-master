package lecture039_Recursion_Day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Permutations {

    public static void main(String[] args) {
        Permutations per = new Permutations();

        System.out.println(per.uniquePrem("abc"));
        System.out.println(per.uniquePrem("aa"));
        System.out.println(per.uniquePrem("bca"));
    }

    public ArrayList<String> uniquePrem(String str) {

        Set<String> ans = new HashSet<>();

        if (isAllSameChar(str)) {
            ans.add(str);
        } else {
            permutations(new StringBuilder(str), ans, 0);
        }

        ArrayList<String> result = new ArrayList<>(ans);
        Collections.sort(result);

        return result;
    }

    private void permutations(StringBuilder str, Set<String> ans, int index) {

        // Base case
        if (index >= str.length()) {
            ans.add(str.toString());
            return;
        }

        char tempCh = ' ';
        for (int j = index; j < str.length(); j++) {
            tempCh = str.charAt(index);
            str.setCharAt(index, str.charAt(j));
            str.setCharAt(j, tempCh);

            permutations(str, ans, index + 1);

            // backtrack (swap value in same string so back to original string after work done)
            tempCh = str.charAt(index);
            str.setCharAt(index, str.charAt(j));
            str.setCharAt(j, tempCh);

        }

    }

    private boolean isAllSameChar(String str) {

        int size = str.length();
        for (int i = 1; i < size; i++) {
            if (str.charAt(i) != str.charAt(0)) {
                return false;
            }
        }

        return true;
    }

}

