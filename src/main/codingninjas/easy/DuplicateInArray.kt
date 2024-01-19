package easy


fun main() {
    val result = findDuplicate(listOf(6, 3, 1, 5, 4, 3, 2))
    println("Duplicate element is = $result")
}

private fun findDuplicate(arr: List<Int>): Int {

    var ans = 0

    for (element in arr) {
        print("$ans xor $element = ")
        ans = ans xor element
        print("$ans")
        println()
    }

    println()

    for (index in 1..<arr.size) {
        print("$ans xor $index = ")
        ans = ans xor index
        print("$ans")
        println()
    }

    println()

    return ans
}