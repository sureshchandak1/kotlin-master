import java.util.Iterator;
import java.util.PriorityQueue;

public class RearrangeString {

    public static void main(String[] args) {
        System.out.println(rearrangeString("aac"));
    }

    public static String rearrangeString(String str) {

        int size = str.length();
        PriorityQueue<Character> pq = new PriorityQueue<>();

        StringBuilder result = new StringBuilder();
        int newStrIndex = 0;

        int index = 0;
        while (index < size) {
            if (newStrIndex == 0) {
                result.append(str.charAt(index));
                newStrIndex++;
            } else {
                if (str.charAt(index) != result.charAt(newStrIndex - 1)) {
                    result.append(str.charAt(index));
                    newStrIndex++;
                } else {
                    Iterator<Character> itr = pq.iterator();
                    while (itr.hasNext()) {
                        char ch = pq.peek();
                        if (ch != result.charAt(newStrIndex - 1)) {
                            result.append(str.charAt(index));
                            newStrIndex++;
                            pq.poll();
                        }
                    }
                    pq.offer(str.charAt(index));
                }
            }

            index++;
        }

        if (newStrIndex + 1 == size) {
            return result.toString();
        }

        return "NO SOLUTION";

    }

}
