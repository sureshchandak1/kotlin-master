package _14

fun main() {
    println("36 Square Root = ${square(36)}")
}

private fun square(n: Int): Int {

    var start = 0
    var end = n
    var mid = start + (end - start) / 2

    var ans = -1

    while (start <= end) {
        val squ = mid * mid

        if (squ == n) {
            return mid
        }

        if (squ > n) {
            end = mid - 1
        } else {
            ans = mid
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return ans
}
