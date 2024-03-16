package lecture063_Tree_Interview_Questions_Day1

import lecture062_Tree_Introduction.BinaryTreeNode

/*
*   https://www.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
* */
fun main() {

}

private fun identicalTrees(root1: BinaryTreeNode<Int>?, root2: BinaryTreeNode<Int>?): Boolean {

    // Base case
    if (root1 == null && root2 == null) {
        return true
    }
    if (root1 == null && root2 != null) {
        return false
    }
    if (root1 != null && root2 == null) {
        return false
    }

    val left = identicalTrees(root1!!.left, root2!!.left)
    val right = identicalTrees(root1.right, root2.right)
    val isSameValue = root1.data == root2.data

    return left && right && isSameValue
}