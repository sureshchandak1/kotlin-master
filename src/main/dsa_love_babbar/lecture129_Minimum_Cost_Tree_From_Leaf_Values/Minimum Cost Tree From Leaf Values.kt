package lecture129_Minimum_Cost_Tree_From_Leaf_Values

/**
 *    https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/
 */
fun main() {
    println(mctFromLeafValues(intArrayOf(6, 2, 4)))
    println(mctFromLeafValues(intArrayOf(4, 11)))
    println(mctFromLeafValues(intArrayOf(5, 1, 2, 3, 15, 7, 3, 2, 2, 5, 9, 1, 11, 9, 15, 14, 7, 1, 5)))
}

private fun mctFromLeafValues(arr: IntArray): Int {
    val maxi = HashMap<Pair<Int, Int>, Int>()

    for (i in arr.indices) {
        maxi[Pair(i, i)] = arr[i]

        for (j in i + 1..<arr.size) {
            maxi[Pair(i, j)] = Math.max(arr[j], maxi[Pair(i, j - 1)]!!)
        }
    }

    val n = arr.size
    val dp = Array(n + 1) { IntArray(n + 1) { -1 } }

    return solveMem(arr, maxi, 0, arr.size - 1, dp)
}

private fun solve(arr: IntArray, maxi: MutableMap<Pair<Int, Int>, Int>, left: Int, right: Int): Int {

    // Base case
    if (left == right) {
        return 0
    }

    var ans = Int.MAX_VALUE

    for (i in left..<right) {
        ans = Math.min(
            ans,
            (maxi[Pair(left, i)]!! * maxi[Pair(i + 1, right)]!!) + solve(arr, maxi, left, i) + solve(
                arr,
                maxi,
                i + 1,
                right
            )
        )
    }

    return ans
}

private fun solveMem(
    arr: IntArray,
    maxi: MutableMap<Pair<Int, Int>, Int>,
    left: Int,
    right: Int,
    dp: Array<IntArray>
): Int {

    // Base case
    if (left == right) {
        return 0
    }

    if (dp[left][right] != -1) {
        return dp[left][right]
    }

    var ans = Int.MAX_VALUE

    for (i in left..<right) {
        ans = Math.min(
            ans,
            (maxi[Pair(left, i)]!! * maxi[Pair(i + 1, right)]!!) + solveMem(arr, maxi, left, i, dp) + solveMem(
                arr,
                maxi,
                i + 1,
                right,
                dp
            )
        )
    }

    dp[left][right] = ans

    return dp[left][right]
}


private fun mapWithPair(arr: IntArray) {
    val maxi = HashMap<Pair<Int, Int>, Int>()

    for (i in arr.indices) {
        maxi[Pair(i, i)] = arr[i]

        for (j in i + 1..<arr.size) {
            maxi[Pair(i, j)] = Math.max(arr[j], maxi[Pair(i, j - 1)]!!)
        }
    }

    for (i in arr.indices) {
        for (j in i..<arr.size) {
            println("for range $i->$j max is ${maxi[Pair(i, j)]}")
        }
    }
}


