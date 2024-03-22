package lecture068_Tree_Interview_Questions_Day6

import lecture062_Tree_Introduction.TreeNode

/*
*  https://www.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1
* */

fun main() {
    val root = TreeNode(8)
    root.left = TreeNode(3)
    root.right = TreeNode(10)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(6)
    root.right!!.right = TreeNode(14)
    root.right!!.right!!.left = TreeNode(13)
    root.left!!.right!!.left = TreeNode(4)
    root.left!!.right!!.right = TreeNode(7)

    println("Before: ")
    inorder(root)
    println()

    flatten(root)

    println("After: ")
    inorder(root)
}

private fun flatten(root: TreeNode?) {

    var curr: TreeNode? = root

    while (curr != null) {

        if (curr.left != null) {

            var pred: TreeNode? = curr.left
            while (pred?.right != null) {
                pred = pred.right
            }

            pred?.right = curr.right
            curr.right = curr.left
            curr.left = null
        }

        curr = curr.right
    }


    // left part null
    /*curr = root;
    while (curr != null) {
        curr.left = null;
        curr = curr.right;
    }*/
}

private fun inorder(root: TreeNode?) {

    // Base case
    if (root == null) {
        return
    }

    inorder(root.left)

    print("${root.data}  ")

    inorder(root.right)
}