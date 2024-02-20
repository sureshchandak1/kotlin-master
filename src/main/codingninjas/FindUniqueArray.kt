fun main() {
    val result = findUnique(intArrayOf(2, 3, 1, 6, 3, 6, 2))
    println("Unique value is = $result")
}

private fun findUnique(arr: IntArray): Int {

    var ans = 0

    for (element in arr) {
        print("$ans xor $element = ")
        ans = ans xor element
        print("$ans")
        println()
    }

    return ans
}