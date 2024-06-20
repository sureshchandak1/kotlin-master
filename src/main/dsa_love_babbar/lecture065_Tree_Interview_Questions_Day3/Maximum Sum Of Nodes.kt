package lecture065_Tree_Interview_Questions_Day3

import lecture063_Tree_Interview_Questions_Day1.TreeNode
import kotlin.math.max

/*
*   https://www.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
* */
fun main() {

}

private fun maximumSumOfNodes(root: TreeNode<Int>?): Int {
    val ans = solve(root)
    return max(ans.includeSum.toDouble(), ans.excludeSum.toDouble()).toInt()
}

private fun solve(root: TreeNode<Int>?): PairMaxSum {

    // Base case
    if (root == null) {
        return PairMaxSum(0, 0)
    }

    val left = solve(root.left)
    val right = solve(root.right)

    val ans = PairMaxSum(0, 0)

    ans.includeSum = root.data + left.excludeSum + right.excludeSum

    ans.excludeSum = (max(left.includeSum.toDouble(), left.excludeSum.toDouble()) + max(
        right.includeSum.toDouble(),
        right.excludeSum.toDouble()
    )).toInt()

    return ans
}

private class PairMaxSum(includeSum: Int, excludeSum: Int) {
    var includeSum: Int = 0
    var excludeSum: Int = 0

    init {
        this.includeSum = includeSum
        this.excludeSum = excludeSum
    }
}