package lecture071_BST_Interview_Questions_Day2

import lecture062_Tree_Introduction.TreeNode

/*
*    https://www.codingninjas.com/studio/problems/normal-bst-to-balanced-bst_920472
* */
fun main() {

}

private fun balancedBst(root: TreeNode?): TreeNode? {
    val inorderVal: MutableList<Int> = ArrayList()
    // store inorder - sorted values
    inorder(root, inorderVal)
    val size = inorderVal.size

    return inorderToBST(0, size - 1, inorderVal)
}

private fun inorderToBST(start: Int, end: Int, inorder: List<Int>): TreeNode? {

    // Base case
    if (start > end) {
        return null
    }

    val mid = start + (end - start) / 2
    val root: TreeNode = TreeNode(inorder[mid])
    root.left = inorderToBST(start, mid - 1, inorder)
    root.right = inorderToBST(mid + 1, end, inorder)

    return root
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



