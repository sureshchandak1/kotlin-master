package lecture070_BST_Interview_Questions_Day1

import Wrapper
import lecture062_Tree_Introduction.TreeNode

/*
*  https://www.codingninjas.com/studio/problems/kth-largest-element-in-bst_4414080
* */

fun main() {

}

private fun kthLargest(root: TreeNode?, k: Int): Int {

    val totalNodes: Wrapper<Int> = Wrapper(0)

    inorder(root, totalNodes)

    val ans = solve(root, Wrapper(0), totalNodes.value - k + 1)
    return ans
}

private fun solve(root: TreeNode?, i: Wrapper<Int>, k: Int): Int {

    // base case
    if (root == null) {
        return -1
    }

    // L
    val left = solve(root.left, i, k)
    if (left != -1) {
        return left
    }

    // N
    i.value++
    if (i.value == k) {
        return root.data
    }

    // R
    return solve(root.right, i, k)
}

private fun inorder(root: TreeNode?, totalNodes: Wrapper<Int>) {

    // Base case
    if (root == null) {
        return
    }

    // L
    inorder(root.left, totalNodes)

    // N
    totalNodes.value++

    // R
    inorder(root.right, totalNodes)
}
