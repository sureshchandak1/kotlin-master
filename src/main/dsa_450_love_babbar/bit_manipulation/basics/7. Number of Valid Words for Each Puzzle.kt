package bit_manipulation.basics

import printArray

/**
 *    https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/description/
 */
fun main() {
    var words = arrayOf("aaaa","asas","able","ability","actt","actor","access")
    var puzzles = arrayOf("aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz")

    printArray(findNumOfValidWords(words, puzzles))

    words = arrayOf("apple","pleas","please")
    puzzles = arrayOf("aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy")

    printArray(findNumOfValidWords(words, puzzles))
}

private fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): MutableList<Int> {

    val map: MutableMap<Char, MutableList<Int>> = HashMap()
    for (ch in 'a' .. 'z') {
        map[ch] = ArrayList<Int>()
    }

    for (word in words) {
        var mask = 0
        for (ch in word.toCharArray()) {
            val bit = ch - 'a'
            mask = mask or (1 shl bit)
        }

        val unique = HashSet<Char>()
        for (ch in word.toCharArray()) {

            if (unique.contains(ch)) {
                continue
            }

            unique.add(ch)
            map[ch]!!.add(mask)
        }
    }

    val res = ArrayList<Int>()

    for (puzzle in puzzles) {
        var pMask = 0
        for (ch in puzzle.toCharArray()) {
            val bit = ch - 'a'
            pMask = pMask or (1 shl bit)
        }

        val fCh = puzzle[0]

        val wordsToCheck: MutableList<Int> = map[fCh]!!
        var count = 0
        for (wMask in wordsToCheck) {
            if ((wMask and pMask) == wMask) {
                count++
            }
        }

        res.add(count)

    }

    return res
}











