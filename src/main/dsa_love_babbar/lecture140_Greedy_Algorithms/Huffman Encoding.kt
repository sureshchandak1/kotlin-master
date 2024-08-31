package lecture140_Greedy_Algorithms

import printArray
import java.util.*

/**
 *     https://www.geeksforgeeks.org/problems/huffman-encoding3345/1
 *     Time Complexity: O(n * (log n))
 *     Space Complexity: O(n)
 */
fun main() {
    var frequency = intArrayOf(8, 9, 14, 19, 20, 21, 21, 25, 33, 45, 50, 50, 66, 68, 70, 73, 74, 75, 76, 82, 85, 90, 94, 97, 100)
    printArray(huffmanCodes("qwertyuiopasdfghjklzxcvbn", frequency, frequency.size))
    frequency = intArrayOf(5, 9, 12, 13, 16, 45)
    printArray(huffmanCodes("abcdef", frequency, frequency.size))
}

private fun huffmanCodes(str: String, f: IntArray, n: Int): ArrayList<String> {

    val minPq = PriorityQueue<HuffmanNode>(n) { n1, n2 -> n1.data - n2.data }

    for (i in 0..< n) {
        val node = HuffmanNode(f[i])
        node.ch = str[i]
        minPq.add(node)
    }

    var root: HuffmanNode? = null

    while (minPq.size > 1) {
        val left = minPq.remove()
        val right = minPq.remove()

        val newNode = HuffmanNode(left.data + right.data)
        newNode.left = left
        newNode.right = right
        newNode.ch = '-'

        root = newNode

        minPq.add(newNode)
    }

    val ans = ArrayList<String>()
    val temp = ""

    traverse(root, ans, temp)

    return ans
}

private fun traverse(root: HuffmanNode?, ans: ArrayList<String>, temp: String) {

    // Base case
    if (root!!.left == null && root.right == null && Character.isLetter(root.ch)) {
        ans.add(temp)
        //println(temp)
        return
    }

    if (root.left != null) {
        traverse(root.left, ans, temp + "0")
    }

    if (root.right != null) {
        traverse(root.right, ans, temp + "1")
    }
}

private class HuffmanNode(data: Int) {
    var data: Int = 0
    var ch: Char = ' '
    var left: HuffmanNode? = null
    var right: HuffmanNode? = null

    init {
        this.data = data
    }
}




