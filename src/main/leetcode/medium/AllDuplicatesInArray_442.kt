package medium

fun main() {
    findDuplicates(intArrayOf(4,3,2,7,8,2,3,1))
}

private fun findDuplicates(arr: IntArray): List<Int> {

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

    return listOf()

}