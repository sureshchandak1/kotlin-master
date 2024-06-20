package bit_manipulation

/**
 *    https://www.geeksforgeeks.org/problems/copy-set-bits-in-range0623/1
 */
fun main() {
    println(setSetBit(44, 3, 1, 5))
    println(setSetBit(16, 2, 1, 3))
}

private fun setSetBit(x: Int, y: Int, l: Int, r: Int): Int {

    var xValue = x

    // return if l less than 1 or r grater than 32
    if (l < 1 || r > 32) {
        return xValue
    }

    for (i in l .. r) {
        val mask = 1 shl (i - 1)

        if ((y and mask) != 0) {
            xValue = xValue or mask
        }
    }

    return xValue
}



