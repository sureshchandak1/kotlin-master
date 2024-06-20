package lecture077_Heap_Interview_Questions_Day3

import java.util.*

/*
*   https://www.naukri.com/code360/problems/rearrange-string_982765
* */
fun main() {
    println(reArrangeString("coding"))
    println(reArrangeString("abaab"))
    println(reArrangeString("bbbbbb"))
    println(reArrangeString("rastemorde"))
    println(reArrangeString("gameover"))
    println(reArrangeString("vvvio"))
}

private const val MAX_CHAR = 26

private fun reArrangeString(s: String): String {

    val n = s.length

    // Store frequencies of all characters in string
    val count = IntArray(MAX_CHAR)

    for (i in 0..< n) {
        count[s[i].code - 'a'.code]++
    }

    // Insert all characters with their
    // frequencies into a priority_queue
    val minHeap = PriorityQueue(KeyComparator())

    var c = 'a'
    while (c <= 'z') {
        val value = c.code - 'a'.code
        if (count[value] > 0) {
            minHeap.add(Key(count[value], c))
        }
        c++
    }

    var ans = ""

    var prev = Key(-1, '#')

    while (minHeap.size != 0) {
        val temp = minHeap.peek()
        minHeap.poll()

        ans += temp.ch

        // If frequency of previous character
        // is less than zero that means it is
        // useless, we need not to push it
        if (prev.freq > 0) {
            minHeap.add(prev)
        }

        temp.freq--

        prev = temp
    }

    return if (n != ans.length) {
        "not possible"
    } else {
        ans
    }
}

private class KeyComparator : Comparator<Key> {
    override fun compare(k1: Key, k2: Key): Int {
        if (k1.freq < k2.freq) {
            return 1
        } else if (k1.freq > k2.freq) {
            return -1
        }

        return 0
    }
}

private class Key(// frequency of character
    var freq: Int, var ch: Char
)


