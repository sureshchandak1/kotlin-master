package lecture021_Solving_ArrayQuestions2

import printArray


fun main() {
    val a = intArrayOf(4, 5, 1)
    val b = intArrayOf(3, 4, 5)

    val arraySum = findArraySum(a, 3, b, 3)

    printArray(a)
    printArray(b)
    printArray(arraySum)
}

private fun findArraySum(a: IntArray, n: Int, b: IntArray, m: Int): IntArray {

    var i = n - 1
    var j = m - 1

    val ans: MutableList<Int> = ArrayList()

    var carry = 0
    var sum = 0

    while (i >= 0 && j >= 0) {
        sum = a[i] + b[j] + carry

        carry = sum / 10
        sum %= 10

        ans.add(sum)

        i--
        j--
    }

    while (i >= 0) {
        sum = a[i] + carry

        carry = sum / 10
        sum %= 10

        ans.add(sum)

        i--
    }

    while (j >= 0) {
        sum = b[j] + carry

        carry = sum / 10
        sum %= 10

        ans.add(sum)

        j--
    }

    while (carry != 0) {
        sum = carry

        carry = sum / 10
        sum %= 10

        ans.add(sum)
    }

    reverse(ans)

    val result = IntArray(ans.size)

    for (index in ans.indices) {
        result[index] = ans[index]
    }

    return result
}

private fun reverse(list: MutableList<Int>) {

    var start = 0
    var end = list.size - 1

    var temp = 0
    while (start < end) {
        temp = list[start]
        list[start] = list[end]
        list[end] = temp

        start++
        end--
    }
}