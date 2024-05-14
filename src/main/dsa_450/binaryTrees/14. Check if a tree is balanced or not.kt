package binaryTrees

import kotlin.math.abs
import kotlin.math.max

/**
 *    A height-balanced binary tree is a binary tree in which
 *    the depth of the two subtrees of every node never differs by more than one.
 *    https://leetcode.com/problems/balanced-binary-tree/description/
 *    Time complexity: O(n)
 *    Space complexity: O(n)
 */
fun main() {
    val root = TreeBuilder.buildTree()
    println("isBalanced = ${isBalanced(root)}")
}

private fun isBalanced(root: TreeNode?): Boolean {

    if (root == null) {
        return true
    }

    /*
    val leftHeight = height(root.left)
    val rightHeight = height(root.right)

    return Math.abs(leftHeight - rightHeight) <= 1
    */

    return isBalancedTree(root).first
}

/**
 *   @return Pair<Boolean, Int> = Pair<isBalanced, height>
 */
private fun isBalancedTree(root: TreeNode?): Pair<Boolean, Int> {

    // Base case
    if (root == null) {
        return Pair(true, 0)
    }

    val left = isBalancedTree(root.left)
    val right = isBalancedTree(root.right)
    val diff = abs(left.second - right.second) <= 1 // balanced tree condition

    val isBalanced = left.first && right.first && diff
    val height = max(left.second, right.second) + 1

    return Pair(isBalanced, height)
}

private fun height(root: TreeNode?): Int {

    // Base case
    if (root == null) {
        return 0
    }

    val leftHeight = height(root.left)

    val rightHeight = height(root.right)

    return max(leftHeight, rightHeight) + 1
}







