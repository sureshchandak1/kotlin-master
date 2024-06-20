package lecture069_Binary_Search_Tree_Implementation

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1
* */

fun main() {

}

private fun deleteNode(root: TreeNode?, x: Int): TreeNode? {

    // Base case
    if (root == null) {
        return null
    }

    if (root.data == x) {
        // 0 child
        if (root.left == null && root.right == null) {
            return null
        }

        // 1 child
        // left child
        if (root.left != null && root.right == null) {
            return root.left
        }

        // right child
        if (root.left == null && root.right != null) {
            return root.right
        }

        // 2 child
        if (root.left != null && root.right != null) {
            val min = minimum(root.right)
            root.data = min
            root.right = deleteNode(root.right, min)
            return root
        }

    } else if (root.data > x) {
        root.left = deleteNode(root.left, x)
        return root
    } else {
        root.right = deleteNode(root.right, x)
        return root
    }

    return root
}

private fun minimum(root: TreeNode?): Int {
    var curr: TreeNode? = root

    while (curr!!.left != null) {
        curr = curr.left
    }

    return curr.data
}


