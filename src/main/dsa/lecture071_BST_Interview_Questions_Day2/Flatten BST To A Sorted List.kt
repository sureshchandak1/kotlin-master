package lecture071_BST_Interview_Questions_Day2

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.codingninjas.com/studio/problems/flatten-bst-to-a-sorted-list_1169459
* */
fun main() {

}

private fun flatten(root: TreeNode?): TreeNode {

    val inorderVal: MutableList<Int> = ArrayList()
    // store inorder - sorted values
    inorder(root, inorderVal)
    val size = inorderVal.size

    val newRoot = TreeNode(inorderVal[0])

    var curr: TreeNode = newRoot

    for (i in 1..< size) {

        val newNode = TreeNode(inorderVal[i])

        curr.left = null
        curr.right = newNode
        curr = newNode
    }

    return newRoot
}

private fun inorder(root: TreeNode?, inorderVal: MutableList<Int>) {

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
