package lecture079_Trie_and_Implementation

fun main() {
    val trie = TrieImplement()

    trie.insert("ARM")
    trie.insert("ARE")
    trie.insert("do")
    trie.insert("Time")

    println("TIME = ${trie.search("TIME")}")
    println("Tim = ${trie.search("Tim")}")
    println("Do = ${trie.search("Do")}")

    println("AR = ${trie.startsWith("AR")}")
}

class TrieImplement internal constructor() {

    private val root: TrieNode = TrieNode(Char.MIN_VALUE)

    //Inserts a word into the trie
    fun insert(word: String?) {
        insert(root, word!!)
    }

    private fun insert(root: TrieNode?, word: String) {
        // Base case
        if (word.isEmpty()) {
            root!!.isTerminal = true
            return
        }

        val index = word[0].code - 'a'.code
        var child: TrieNode? = null

        // Present
        if (root!!.children[index] != null) {
            child = root.children[index]
        } else {
            // Absent
            child = TrieNode(word[0])
            root.children[index] = child
        }

        insert(child, word.substring(1))
    }


    //Returns if the word is in the trie
    fun search(word: String?): Boolean {
        return search(root, word!!)
    }

    private fun search(root: TrieNode?, word: String): Boolean {
        // Base case
        if (word.isEmpty()) {
            return root!!.isTerminal
        }

        val index = word[0].code - 'a'.code
        var child: TrieNode? = null

        // Present
        if (root!!.children[index] != null) {
            child = root.children[index]
        } else {
            // Absent
            return false
        }

        return search(child, word.substring(1))
    }

    //Returns if there is any word in the trie that starts with the given prefix
    fun startsWith(prefix: String?): Boolean {
        return startsWith(root, prefix!!)
    }

    private fun startsWith(root: TrieNode?, word: String): Boolean {
        // Base case
        if (word.isEmpty()) {
            return true
        }

        val index = word[0].code - 'a'.code
        var child: TrieNode? = null

        // Present
        if (root!!.children[index] != null) {
            child = root.children[index]
        } else {
            // Absent
            return false
        }

        return startsWith(child, word.substring(1))
    }

    private class TrieNode(var data: Char) {
        var children: Array<TrieNode?> = arrayOfNulls<TrieNode>(26)
        var isTerminal: Boolean = false

        init {
            for (i in 0..25) {
                children[i] = null
            }
            isTerminal = false
        }
    }

}