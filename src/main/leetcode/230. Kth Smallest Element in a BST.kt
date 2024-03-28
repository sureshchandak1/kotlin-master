import lecture062_Tree_Introduction.TreeNode

/*
*   https://leetcode.com/problems/kth-smallest-element-in-a-bst/
* */
fun main() {

}

private fun kthSmallest(root: TreeNode?, k: Int): Int {
    val ans = solve(root, Wrapper(0), k)
    return ans
}

private fun solve(root: TreeNode?, i: Wrapper<Int>, k: Int): Int {

    // Base case
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