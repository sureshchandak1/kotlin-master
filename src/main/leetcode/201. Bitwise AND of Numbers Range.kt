fun main() {
    println(rangeBitwiseAnd(5, 9))
}

private fun rangeBitwiseAnd(left: Int, right: Int): Int {

    var left = left
    var right = right

    println("left = ${Integer.toBinaryString(left)}")
    println("right = ${Integer.toBinaryString(right)}")

    var count = 0
    while (left != right) {
        left = left shr 1
        right = right shr 1

        println("left = ${Integer.toBinaryString(left)}")
        println("right = ${Integer.toBinaryString(right)}")

        count++
    }

    println("count = $count")
    val ans = left shl count
    println("ans = ${Integer.toBinaryString(ans)}")

    return ans
}