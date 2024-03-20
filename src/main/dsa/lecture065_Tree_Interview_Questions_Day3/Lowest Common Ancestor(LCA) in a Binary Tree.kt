package lecture065_Tree_Interview_Questions_Day3

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
* */
fun main() {

}

private fun lca(root: TreeNode?, n1: Int, n2: Int): TreeNode? {

    // Base case
    if (root == null) {
        return null
    }
    if (root.data == n1 || root.data == n2) {
        return root
    }

    val leftAns: TreeNode? = lca(root.left, n1, n2)
    val rightAns: TreeNode? = lca(root.right, n1, n2)

    return if (leftAns != null && rightAns != null) {
        root
    } else if (leftAns != null && rightAns == null) {
        leftAns
    } else if (leftAns == null && rightAns != null) {
        rightAns
    } else {
        null
    }
}

private fun lowestCommonAncestor(root: TreeNode?, x: Int, y: Int): Int? {

    // Base case
    if (root == null) {
        return -1
    }
    if (root.data == x || root.data == y) {
        return root.data
    }

    val leftAns = lowestCommonAncestor(root.left, x, y)
    val rightAns = lowestCommonAncestor(root.right, x, y)

    return if (leftAns != -1 && rightAns != -1) {
        root.data
    } else if (leftAns != -1 && rightAns == -1) {
        leftAns
    } else if (leftAns == -1 && rightAns != -1) {
        rightAns
    } else {
        -1
    }
}

