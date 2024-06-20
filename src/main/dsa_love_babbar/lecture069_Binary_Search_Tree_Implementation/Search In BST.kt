package lecture069_Binary_Search_Tree_Implementation

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.geeksforgeeks.org/problems/search-a-node-in-bst/1
* */
fun main() {

}

private fun searchInBST(root: TreeNode?, x: Int): Boolean {

    var curr = root

    while (curr != null) {
        if (curr.data == x) {
            return true
        }

        curr = if (curr.data > x) {
            curr.left
        } else {
            curr.right
        }
    }

    return false
}

private fun search(root: TreeNode?, x: Int): Boolean {

    // Base case
    if (root == null) {
        return false
    }
    if (root.data == x) {
        return true
    }

    return if (root.data > x) {
        // Left part
        search(root.left, x)
    } else {
        // Right part
        search(root.right, x)
    }
}