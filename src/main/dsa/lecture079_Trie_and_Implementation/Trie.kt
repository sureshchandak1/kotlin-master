package lecture079_Trie_and_Implementation

fun main() {
    val trie = Trie()

    trie.insertWord("ARM")
    trie.insertWord("ARE")
    trie.insertWord("do")
    trie.insertWord("Time")

    println("TIME = ${trie.searchWord("TIME")}")
    println("Tim = ${trie.searchWord("Tim")}")
    println("Do = ${trie.searchWord("Do")}")

    trie.removeWord("Do")

    println("Do = ${trie.searchWord("Do")}")

    trie.removeWord("ARM")

    println("ARM = ${trie.searchWord("ARM")}")
    println("ARE = ${trie.searchWord("ARE")}")
}

private class Trie {
    val root: TrieNode = TrieNode(Char.MIN_VALUE)

    fun insertWord(word: String) {
        insertWord(root = root, word = word)
    }

    // O(l) = l = length of word
    private fun insertWord(root: TrieNode?, word: String) {
        // Base case
        if (word.isEmpty()) {
            root?.isTerminal = true
            return
        }

        // assumption, word will be in CAPS
        val index = word[0].uppercase()[0] - 'A'
        var child: TrieNode? = null

        // present
        if (root!!.children[index] != null) {
            child = root.children[index]
        } else {
            // absent
            child = TrieNode(word[0])
            root.children[index] = child
        }

        // recursion
        insertWord(child, word.substring(1))
    }

    fun searchWord(word: String): Boolean {
        return searchWord(root = root, word = word)
    }

    // O(l) = l = length of word
    private fun searchWord(root: TrieNode?, word: String): Boolean {
        // Base case
        if (word.isEmpty()) {
            return root!!.isTerminal
        }

        // assumption, word will be in CAPS
        val index = word[0].uppercase()[0] - 'A'
        var child: TrieNode? = null

        // present
        if (root!!.children[index] != null) {
            child = root.children[index]
        } else {
            // absent
            return false
        }

        // recursion
        return searchWord(child, word.substring(1))
    }

    fun removeWord(word: String) {
        removeWord(root, word)
    }

    private fun removeWord(root: TrieNode?, word: String): TrieNode? {
        var root = root
        // Base case
        if (word.isEmpty()) {
            if (root!!.isTerminal) {
                root.isTerminal = false
            }

            if (isEmpty(root)) {
                root = null
            }

            return root
        }

        val index = word[0].uppercase()[0] - 'A'
        root!!.children[index] = removeWord(root.children[index], word.substring(1))

        if (isEmpty(root) && !root.isTerminal) {
            root = null
        }

        return root
    }

    private fun isEmpty(root: TrieNode?): Boolean {
        if (root == null) {
            return true
        }
        for (i in 0..<26) {
            if (root.children[i] != null) {
                return false
            }
        }

        return true
    }
}

private class TrieNode(ch: Char) {

    var data: Char = ch
    val children: Array<TrieNode?> = Array(26) { null }
    var isTerminal: Boolean = false

}