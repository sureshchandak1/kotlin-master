package lecture070_BST_Interview_Questions_Day1

import lecture062_Tree_Introduction.BinaryTreeNode

/*
*   https://www.codingninjas.com/studio/problems/validate-bst_799483
* */
fun main() {

}

private fun validateBST(root: BinaryTreeNode<Int>?): Boolean {
    return isBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
}

private fun isBST(root: BinaryTreeNode<Int>?, min: Int, max: Int): Boolean {

    // Base case
    if (root == null) {
        return true
    }

    if (root.data in min..max) {
        val left = isBST(root.left, min, root.data)
        val right = isBST(root.right, root.data, max)

        return left && right
    }

    return false
}