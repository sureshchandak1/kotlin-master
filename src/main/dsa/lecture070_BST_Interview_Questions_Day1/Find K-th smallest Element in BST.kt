package lecture070_BST_Interview_Questions_Day1

import Wrapper
import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.codingninjas.com/studio/problems/find-k-th-smallest-element-in-bst_1069333
* */
fun main() {

}

private fun kthSmallest(root: TreeNode?, k: Int): Int {
    val ans = solve(root, Wrapper(0), k)
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
