package graph

import java.util.*
import kotlin.collections.HashSet

/**
 *   https://www.geeksforgeeks.org/problems/word-ladder/1
 *   https://leetcode.com/problems/word-ladder/description/
 *   Time complexity: O(n * m * 26), where n = size of wordList Array and m = word length of words present in the wordList
 *   Space complexity: O(N) {creating set and queue}
 */
fun main() {
    var startWord = "hit"
    var endWord = "cog"
    var wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
    println(ladderLength(startWord, endWord, wordList))

    startWord = "der"; endWord = "dfs"
    wordList = listOf("des", "der", "dfr", "dgt", "dfs")
    println(ladderLength(startWord, endWord, wordList))
}

private fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {

    if (beginWord == endWord) {
        return 0
    }

    val ans = ladderLengthBFS(beginWord, endWord, wordList)

    return ans
}

// BFS
private fun ladderLengthBFS(beginWord: String, endWord: String, wordList: List<String>): Int {

    val wordSet: MutableSet<String> = HashSet() // search and delete operations in O(1)
    for (str in wordList) {
        wordSet.add(str)
    }

    if (!wordSet.contains(endWord)) {
        return 0
    }

    val q: Queue<Pair<String, Int>> = LinkedList()
    q.add(Pair(beginWord, 1))
    wordSet.remove(beginWord) // delete the word from the wordList

    while (!q.isEmpty()) {

        val front = q.remove()

        val word = front.first
        val steps = front.second

        if (word == endWord) {
            return steps
        }

        val wordCharArray = word.toCharArray()
        val wordLength = wordCharArray.size

        for (i in 0..<wordLength) {
            val originalChar = wordCharArray[i]

            for (ch in 'a'..'z') {
                wordCharArray[i] = ch
                val newWord = String(wordCharArray)

                if (wordSet.contains(newWord)) {
                    q.add(Pair(newWord, steps + 1))
                    wordSet.remove(newWord) // delete the word from the wordList
                }
            }

            // restore the original character
            wordCharArray[i] = originalChar
        }
    }

    // no transformation sequence possible
    return 0
}



