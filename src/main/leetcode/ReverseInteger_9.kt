fun main() {
    val x = readln()
    println(reverse(x.toInt()))
}

private fun reverse(x: Int): Int {
    var value = x

    var ans = 0
    while (value != 0) {
        val digit = value % 10

        if (ans > Int.MAX_VALUE / 10 || ans < Int.MIN_VALUE / 10) {
            return 0
        }

        ans = (ans * 10) + digit

        value /= 10
    }

    return ans
}