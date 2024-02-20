fun main() {
    val result1 = uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3))
    println("$result1 -----------------------------")
    val result2 = uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0))
    println("$result2 -----------------------------")
}

private fun uniqueOccurrences(arr: IntArray): Boolean {

    val countMap: MutableMap<Int, Int> = HashMap()

    // Iterate over the array and populate the countMap.
    for (number in arr) {
        // If the number is already in the map, increment its count, otherwise insert it with count 1.
        countMap.merge(number, 1) { prev, one ->
            Integer.sum(prev, one)
        }
    }

    val occurrenceSet: Set<Int> = HashSet(countMap.values)

    return occurrenceSet.size == countMap.size
}

private fun uniqueOccurrences1(arr: IntArray): Boolean {

    var ans = 0

    for (element in arr) {
        print("$ans xor $element = ")
        ans = ans xor element
        print("$ans")
        println()
    }

    for (index in arr.indices) {
        print("$ans xor $index = ")
        ans = ans xor index
        print("$ans")
        println()
    }

    return ans == 0

}