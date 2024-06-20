package lecture063_Tree_Interview_Questions_Day1

import kotlin.math.abs
import kotlin.math.max

/*
*   https://www.codingninjas.com/studio/problems/is-height-balanced-binary-tree_975497?interviewProblemRedirection=true
* */
fun main() {

}

private fun isBalancedBT(root: TreeNode<Int>?): Boolean {
    return isBalancedFast(root).isBalanced
}

private fun isBalancedFast(root: TreeNode<Int>?): Pair1 {

    // Base case
    if (root == null) {
        val pair = Pair1(true, 0)
        return pair
    }

    val left = isBalancedFast(root.left)
    val right = isBalancedFast(root.right)

    val leftAns = left.isBalanced
    val rightAns = right.isBalanced

    val diff = abs((left.height - right.height).toDouble()) <= 1

    val ans = Pair1(false, 0)
    if (leftAns && rightAns && diff) {
        ans.isBalanced = true
    } else {
        ans.isBalanced = false
    }
    ans.height = (max(left.height.toDouble(), right.height.toDouble()) + 1).toInt()

    return ans
}

private fun isBalanced(root: TreeNode<Int>?): Boolean {

    // Base case
    if (root == null) {
        return true
    }

    val left = isBalanced(root.left)
    val right = isBalanced(root.right)

    val diff = abs((height(root.left) - height(root.right)).toDouble()) <= 1

    if (left && right && diff) {
        return true
    }

    return false
}

private fun height(root: TreeNode<Int>?): Int {

    // Base case
    if (root == null) {
        return 0
    }

    val left = height(root.left)
    val right = height(root.right)

    val ans = (max(left.toDouble(), right.toDouble()) + 1).toInt()

    return ans
}

private class Pair1(isBalanced: Boolean, height: Int) {

    var isBalanced: Boolean = false
    var height: Int = 0

    init {
        this.isBalanced = isBalanced
        this.height = height
    }
}