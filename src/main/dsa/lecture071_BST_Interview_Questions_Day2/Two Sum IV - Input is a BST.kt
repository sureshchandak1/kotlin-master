package lecture071_BST_Interview_Questions_Day2

import lecture062_Tree_Introduction.BinaryTreeNode

/*
*  https://www.codingninjas.com/studio/problems/two-sum-in-a-bst_1062631
* */
fun main() {

}

private fun twoSumInBST(root: BinaryTreeNode<Int>?, target: Int): Boolean {

    val inorderVal: MutableList<Int> = ArrayList()
    // store inorder - sorted values
    inorder(root, inorderVal)

    // use 2 pointer approach to check if pair exists
    var i = 0
    var j = inorderVal.size - 1

    while (i < j) {
        val sum = inorderVal[i] + inorderVal[j]

        if (sum == target) {
            return true
        } else if (sum > target) {
            j--
        } else {
            i++
        }
    }

    return false
}

private fun inorder(root: BinaryTreeNode<Int>?, inorderVal: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    // L
    inorder(root.left, inorderVal)

    // N
    inorderVal.add(root.data)

    // R
    inorder(root.right, inorderVal)
}


