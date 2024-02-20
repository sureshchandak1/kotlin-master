import kotlin.math.min

/**Problem statement
    Ninja has been given a binary string ‘STR’ containing either ‘0’ or ‘1’.
    A binary string is called beautiful if it contains alternating 0s and 1s.

    For Example:‘0101’, ‘1010’, ‘101’, ‘010’ are beautiful strings.

    He wants to make ‘STR’ beautiful by performing some operations on it.
    In one operation, Ninja can convert ‘0’ into ‘1’ or vice versa.

    Your task is to determine the minimum number of operations Ninja should perform to make ‘STR’ beautiful.

    For Example :
    Minimum operations to make ‘STR’ ‘0010’ beautiful is ‘1’.
    In one operation, we can convert ‘0’ at index ‘0’ (0-based indexing) to ‘1’.
    The ‘STR’ now becomes ‘1010’ which is a beautiful string.
**/

fun main() {
    println(makeBeautiful("0000"))
    println(makeBeautiful("1010"))
    println(makeBeautiful("01011"))
    println(makeBeautiful("1001"))
}

private fun makeBeautiful(str: String): Int {
    var s1 = ""
    var s2 = ""

    var s1Count = 0
    var s2Count = 0
    var ans = 0

    for (i in str.indices) {
        if (i % 2 == 0) {
            s1 += "0"
            s2 += "1"
        } else {
            s1 += "1"
            s2 += "0"
        }

        s1Count += (s1[i].code - '0'.code) xor (str[i].code - '0'.code)
        s2Count += (s2[i].code - '0'.code) xor (str[i].code - '0'.code)
    }

    ans = min(s1Count.toDouble(), s2Count.toDouble()).toInt()

    return ans
}