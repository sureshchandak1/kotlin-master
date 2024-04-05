package lecture081_Trie_Interview_Questions_Day2

/*
*   https://www.naukri.com/code360/problems/implement-a-phone-directory_1062666
* */
fun main() {
    var ans = phoneDirectory(arrayListOf("coding", "ninjas"), "cell")
    println(ans.toString())

    ans = phoneDirectory(arrayListOf("ab", "abc"), "a")
    println(ans.toString())

    ans = phoneDirectory(arrayListOf("aaabb", "babaa", "abaaa", "ababb", "babbb"), "abbba")
    println(ans.toString())

    ans = phoneDirectory(arrayListOf("cod", "coding", "codding", "code", "coly"), "coding")
    println(ans.toString())
}

private fun phoneDirectory(contactList: ArrayList<String>, queryStr: String): ArrayList<ArrayList<String>>? {
    val trie = Trie('\u0000')

    for (str in contactList) {
        trie.insert(str)
    }

    return trie.getSuggestions(queryStr)
}

private class Trie(ch: Char) {
    private var root: TrieNode? = null

    init {
        root = TrieNode(ch)
    }

    private fun insert(root: TrieNode?, word: String) {
        // Base case
        if (word.isEmpty()) {
            root!!.isTerminal = true
            return
        }

        val index = word[0].code - 'a'.code
        var child: TrieNode? = null

        if (root!!.children[index] != null) {
            child = root.children[index]
        } else {
            child = TrieNode(word[0])
            root.children[index] = child
        }

        insert(child, word.substring(1))
    }

    fun insert(word: String) {
        insert(root, word)
    }

    fun getSuggestions(str: String): ArrayList<ArrayList<String>>? {
        var prev = root
        val ans = ArrayList<ArrayList<String>>()
        val prefix = StringBuilder()

        for (element in str) {

            prefix.append(element)

            val curr = prev!!.children[element.code - 'a'.code] ?: return ans

            // if found
            val temp = ArrayList<String>()
            printSuggestions(curr, temp, prefix)

            ans.add(temp)
            //temp.clear()

            prev = curr
        }

        return ans
    }

    private fun printSuggestions(curr: TrieNode, temp: MutableList<String>, prefix: StringBuilder) {
        if (curr.isTerminal) {
            temp.add(prefix.toString())
            //println(prefix.toString())
        }

        var ch = 'a'
        while (ch <= 'z') {
            val next = curr.children[ch.code - 'a'.code]

            if (next != null) {
                prefix.append(ch)
                printSuggestions(next, temp, prefix)

                prefix.deleteCharAt(prefix.length - 1)
            }
            ch++
        }
    }
}

private class TrieNode(var data: Char) {
    var children: Array<TrieNode?> = arrayOfNulls(26)
    var isTerminal: Boolean = false

    init {
        for (i in 0..25) {
            children[i] = null
        }
        isTerminal = false
    }
}


