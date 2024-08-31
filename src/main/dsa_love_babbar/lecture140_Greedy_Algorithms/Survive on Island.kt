package lecture140_Greedy_Algorithms

/**
 *    https://www.geeksforgeeks.org/problems/check-if-it-is-possible-to-survive-on-island4922/1
 *    Time Complexity: O(1)
 *    Space Complexity: O(1)
 */
fun main() {
    println(minimumDays(10, 9, 8))
    println(minimumDays(10, 16, 2))
    println(minimumDays(5, 2, 2))
}

private fun minimumDays(s: Int, n: Int, m: Int): Int {

    val sunday = if (s >= 7) {
        s / 7
    } else {
        0
    }

    val buyingDays = s - sunday

    val totalFood = s * m

    var ans = 0

    ans = if (totalFood % n == 0) {
        totalFood / n
    } else {
        totalFood / n + 1
    }

    return if (ans <= buyingDays) {
        ans
    } else {
        -1
    }
}


