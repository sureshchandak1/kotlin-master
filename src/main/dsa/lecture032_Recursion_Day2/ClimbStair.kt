package lecture032_Recursion_Day2

fun main() {
    println(countDistinctWayToClimbStair(4))
    println(countDistinctWayToClimbStair(6))
}

private fun countDistinctWayToClimbStair(nStairs: Long): Int {
    return countWays(nStairs)
}

private fun countWays(position: Int, nStairs: Long): Int {
    if (position > nStairs) {
        return 0
    }

    if (position.toLong() == nStairs) {
        return 1
    }

    val count1Stair = countWays(position + 1, nStairs)
    val count2Stair = countWays(position + 2, nStairs)

    return count1Stair + count2Stair
}

private fun countWays(nStairs: Long): Int {
    if (nStairs < 0) {
        return 0
    }

    if (nStairs == 0L) {
        return 1
    }

    val count1Stair = countWays(nStairs - 1)
    val count2Stair = countWays(nStairs - 2)

    return count1Stair + count2Stair
}