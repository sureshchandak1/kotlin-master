package lecture032_Recursion_Day2

fun main() {
    println(countWays(4))
    println(countWays(6))
}

private fun countWays(position: Int, nStairs: Int): Int {
    if (position > nStairs) {
        return 0
    }

    if (position == nStairs) {
        return 1
    }

    val count1Stair = countWays(position + 1, nStairs)
    val count2Stair = countWays(position + 2, nStairs)

    return count1Stair + count2Stair
}

private fun countWays(nStairs: Int): Int {
    if (nStairs < 0) {
        return 0
    }

    if (nStairs == 0) {
        return 1
    }

    val count1Stair = countWays(nStairs - 1)
    val count2Stair = countWays(nStairs - 2)

    return count1Stair + count2Stair
}