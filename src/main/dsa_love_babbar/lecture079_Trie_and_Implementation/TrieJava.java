package lecture079_Trie_and_Implementation;

public class TrieJava {

    private static TrieNode root = null;

    TrieJava() {
        root = new TrieNode('\0');
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        insert(root, word);
    }

    private static void insert(TrieNode root, String word) {
        // Base case
        if (word.isEmpty()) {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(0) - 'a';
        TrieNode child = null;

        // Present
        if (root.children[index] != null) {
            child = root.children[index];
        }
        else {
            // Absent
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        insert(child, word.substring(1));
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        return search(root, word);
    }

    private static boolean search(TrieNode root, String word) {
        // Base case
        if (word.isEmpty()) {
            return root.isTerminal;
        }

        int index = word.charAt(0) - 'a';
        TrieNode child = null;

        // Present
        if (root.children[index] != null) {
            child = root.children[index];
        }
        else {
            // Absent
            return false;
        }

        return search(child, word.substring(1));
    }

    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        return startsWith(root, prefix);
    }

    private static boolean startsWith(TrieNode root, String word) {
        // Base case
        if (word.isEmpty()) {
            return true;
        }

        int index = word.charAt(0) - 'a';
        TrieNode child = null;

        // Present
        if (root.children[index] != null) {
            child = root.children[index];
        }
        else {
            // Absent
            return false;
        }

        return startsWith(child, word.substring(1));
    }

    private static class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isTerminal = false;

        TrieNode (char d) {
            data = d;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            isTerminal = false;
        }
    }

}
