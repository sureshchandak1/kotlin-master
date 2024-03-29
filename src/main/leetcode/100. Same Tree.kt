import lecture062_Tree_Introduction.TreeNode

/*
*   https://leetcode.com/problems/same-tree/
* */
private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

    // Base case
    if (p == null && q == null) {
        return true
    }
    if (p == null && q != null) {
        return false
    }
    if (p != null && q == null) {
        return false
    }

    val left = isSameTree(p!!.left, q!!.left)
    val right = isSameTree(p.right, q.right)
    val isSameData = p.data == q.data

    return left && right && isSameData
}