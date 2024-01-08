fun main() {
    println(climbStair(2))
    println(climbStair(3))
    println(climbStair(5))
}

private fun climbStair(nStairs: Int) : Int {

    if (nStairs < 0) {
        return 0
    }

    if (nStairs == 0) {
        return 1
    }

    val ans = climbStair(nStairs - 1) + climbStair(nStairs - 2)

    return ans
}