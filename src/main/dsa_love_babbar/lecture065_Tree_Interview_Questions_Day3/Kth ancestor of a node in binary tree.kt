package lecture065_Tree_Interview_Questions_Day3

import lecture062_Tree_Introduction.BinaryTreeNode



/*
*   https://www.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
* */
fun main() {

}

private fun findKthAncestor(root: BinaryTreeNode<Int>?, targetNodeVal: Int, kth: Int): Int {
    val ans = solve(root, targetNodeVal, IntHolder(kth))

    return if (ans == null || ans.data == targetNodeVal) {
        -1
    } else {
        ans.data
    }
}

private fun solve(root: BinaryTreeNode<Int>?, node: Int, kHolder: IntHolder): BinaryTreeNode<Int>? {

    // Base case
    if (root == null) {
        return null
    }
    if (root.data == node) {
        return root
    }

    // left
    val leftAns = solve(root.left, node, kHolder)
    // right
    val rightAns = solve(root.right, node, kHolder)

    if (leftAns != null && rightAns == null) {
        kHolder.kth--
        if (kHolder.kth <= 0) {
            // answer lock
            kHolder.kth = Int.MAX_VALUE
            return root
        }
        return leftAns
    }

    if (leftAns == null && rightAns != null) {
        kHolder.kth--
        if (kHolder.kth <= 0) {
            // answer lock
            kHolder.kth = Int.MAX_VALUE
            return root
        }
        return rightAns
    }

    return null
}

private class IntHolder(kth: Int) {
    var kth: Int = 0

    init {
        this.kth = kth
    }
}

