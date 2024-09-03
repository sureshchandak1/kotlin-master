package lecture140_Greedy_Algorithms

/**
 *    https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/
 */
fun main() {
    println(getLucky("iiii", 1))
    println(getLucky("leetcode", 2))
    println(getLucky("zbax", 2))
}

private fun getLucky(s: String, k: Int): Int {
    var k = k
    var sb: StringBuilder = StringBuilder()

    var total = 0
    for (ch in s.toCharArray()) {
        var num = (ch - 'a' + 1)
        while (num > 0) {
            total += num % 10
            num /= 10
        }
    }

    sb.append(total)

    while(k > 1) {
        var sum = 0

        for (i in sb.indices) {
            sum += (sb[i] - '0')
        }

        k--
        sb = StringBuilder(sum.toString())
    }

    return sb.toString().toInt()
}

private fun solve(s: String, k: Int): Int {
    var k = k
    var sb: StringBuilder = StringBuilder()

    for (ch in s.toCharArray()) {
        sb.append(ch - 'a' + 1)
    }

    while(k > 0) {
        var sum = 0

        for (i in sb.indices) {
            sum += (sb[i] - '0')
        }

        k--
        sb = StringBuilder(sum.toString())
    }

    return sb.toString().toInt()
}





