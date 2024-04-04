package lecture080_Trie_Interview_Questions_Day1

fun main() {
    var arr: Array<String> = arrayOf("coding", "codezen", "codingninja", "coders")
    println(longestCommonPrefix(arr, arr.size))

    arr = arrayOf("zttegyrktnwyicok" ,"dttegyrktnwyicoq", "dttegyrktnwyicoo" ,"dttegyrktnwyicoh", "dttegyrktnwyicon" ,"dttegyrktnwyicou" ,"dttegyrktnwyicop" ,"dttegyrktnwyicog" ,"dttegyrktnwyicox" ,"dttegyrktnwyicoo", "dttegyrktnwyicog" ,"dttegyrktnwyicop" ,"dttegyrktnwyicoj" ,"dttegyrktnwyicoq", "dttegyrktnwyicoe" ,"dttegyrktnwyicov")
    println(longestCommonPrefix(arr, arr.size))

    arr = arrayOf("hsrmmzjqcmuousif", "hsrmmzjqcmuniqtc" ,"hsrmmzjqcmuiubdy", "hsrmmzjqcmutxrfu", "hsrmmzjqcmupeviw" ,"hsrmmzjqcmuenmzx" ,"hsrmmzjqcmupigsh", "hsrmmzjqcmuaanzi", "hsrmmzjqcmubfdzd", "hsrmmzjqcmuayvfc", "hsrmmzjqcmuibrjw", "hsrmmzjqcmudevsr", "hsrmmzjqcmulagph", "hsrmmzjqcmuvlonz", "hsrmmzjqcmuhaodg", "hsrmmzjqcmumyarh", "hsrmmzjqcmuixtko")
    println(longestCommonPrefix(arr, arr.size))
}

/*
*   Time complexity - O(n * m)  n = no. of string,  m = string size
*   Space complexity - O(n * m)
* */
private fun longestCommonPrefix(arr: Array<String>, n: Int): String {

    val trie = Trie('\u0000')

    for (i in 0..< n) {
        trie.insert(arr[i])
    }

    val first = arr[0]
    val ans = StringBuilder()

    trie.commonPrefix(first, ans)

    return ans.toString()
}

/*
*   Time complexity - O(n * m)  n = no. of string,  m = string size
*   Space complexity - O(1)
* */
private fun commonPrefix(arr: Array<String>, n: Int): String {

    var ans = ""

    for (i in 0..< arr[0].length) {
        val iCh = arr[0][i]

        var match = true

        for (j in 1..< n) {
            val str = arr[j]
            if (i < str.length && iCh != str[i]) {
                match = false
                break
            }
        }

        if (!match) {
            break
        } else {
            ans += iCh
        }
    }

    return ans
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
            root.childCount++
            root.children[index] = child
        }

        insert(child, word.substring(1))
    }

    fun insert(word: String) {
        insert(root, word)
    }

    fun commonPrefix(str: String, ans: StringBuilder) {
        val size = str.length
        var curr = root

        for (i in 0..< size) {
            val ch = str[i]

            if (curr!!.childCount == 1) {
                ans.append(ch)

                val index = ch.code - 'a'.code
                curr = curr.children[index]
            } else {
                break
            }

            if (curr!!.isTerminal) {
                break
            }
        }
    }
}

private class TrieNode(var data: Char) {
    var children: Array<TrieNode?> = arrayOfNulls(26)
    var childCount: Int
    var isTerminal: Boolean

    init {
        for (i in 0..25) {
            children[i] = null
        }
        childCount = 0
        isTerminal = false
    }
}





