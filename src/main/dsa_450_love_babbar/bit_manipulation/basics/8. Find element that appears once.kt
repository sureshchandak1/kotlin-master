package bit_manipulation.basics

fun main() {
    var arr = intArrayOf(2, 7, 8, 3, 8, 3, 2)
    println(findElement(arr))

    arr = intArrayOf(5, 3, 6, 4, 5, 6, 3)
    println(findElement(arr))
}

private fun findElement(arr: IntArray): Int {

    var ans = 0
    for (value in arr) {
        ans = ans xor value
    }

    return ans
}