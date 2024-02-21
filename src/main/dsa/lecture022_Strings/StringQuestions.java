package lecture022_Strings;

public class StringQuestions {

    public static void main(String[] args) {
        String str = "N2 i&nJA?a& jnI2n";
        System.out.println(checkPalindrome(str.toLowerCase()));
    }

    private int getLength(char[] arr) {
        int count = 0;

        for (int i = 0; arr[i] != '\0'; i++) {
            count++;
        }

        return count;
    }

    public static boolean checkPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {

            char sCh = str.charAt(start);
            char eCh = str.charAt(end);

            if (!isValidChar(sCh)) {
                start++;
                continue;
            }

            if (!isValidChar(eCh)) {
                end--;
                continue;
            }

            if (sCh != eCh) {
                return false;
            }

            start++;
            end--;
        }

        return true;

    }

    private static boolean isValidChar(char ch) {

        return (ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z') ||
                (ch >= '0' && ch <= '9');

    }

    private static char toLowerCase(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
            return ch;
        } else {
            return (char) (ch - 'A' + 'a');
        }
    }

}
