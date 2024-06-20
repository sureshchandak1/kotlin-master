package lecture065_Tree_Interview_Questions_Day3

import lecture062_Tree_Introduction.TreeNode
import kotlin.math.max

/*
*   https://www.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
* */
fun main() {

}

private var maxSum = 0
private var maxLen = 0

private fun sumOfLongRootToLeafPath(root: TreeNode?): Int {
    solve(root, 0, 0)

    return maxSum
}

private fun solve(root: TreeNode?, sum: Int, len: Int) {

    // Base case
    var sum = sum
    if (root == null) {
        if (len > maxLen) {
            maxLen = len
            maxSum = sum
        } else if (len == maxLen) {
            maxSum = max(sum.toDouble(), maxSum.toDouble()).toInt()
        }

        return
    }

    sum += root.data

    solve(root.left, sum, len + 1)

    solve(root.right, sum, len + 1)
}
