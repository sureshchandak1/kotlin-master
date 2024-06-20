package lecture063_Tree_Interview_Questions_Day1

import lecture062_Tree_Introduction.TreeNode
import kotlin.math.max

/*
*   https://www.codingninjas.com/studio/problems/tree-height_4609628
* */

fun main() {

}

private fun heightOfBinaryTree(root: TreeNode?): Int {

    // Base case
    if (root == null) {
        return 0
    }

    val left = heightOfBinaryTree(root.left)
    val right = heightOfBinaryTree(root.right)

    val ans = (max(left.toDouble(), right.toDouble()) + 1).toInt()

    return ans
}