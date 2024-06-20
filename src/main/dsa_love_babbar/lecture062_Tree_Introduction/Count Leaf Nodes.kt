package lecture062_Tree_Introduction

import java.util.*

/*
*   https://www.codingninjas.com/studio/problems/count-leaf-nodes_893055
*
* */

fun main() {

}

private fun noOfLeafNodes(root: BinaryTreeNode<Int>?): Int {
    return inorder(root, 0)
}

private fun leafNodesCount(root: BinaryTreeNode<Int>): Int {
    var count = 0

    val q: Queue<BinaryTreeNode<*>?> = LinkedList()
    q.add(root)

    var temp: BinaryTreeNode<*>? = null
    while (!q.isEmpty()) {
        temp = q.remove()

        if (temp != null) {
            if (temp.left != null) {
                q.add(temp.left)
            }

            if (temp.right != null) {
                q.add(temp.right)
            }

            if (temp.left == null && temp.right == null) {
                count++
            }
        }
    }

    return count
}

private fun inorder(root: BinaryTreeNode<Int>?, count: Int): Int {
    // L N R
    var count = count
    if (root == null) {
        return count
    }

    val leftLeafCount = inorder(root.left, count)

    if (root.left == null && root.right == null) {
        count++
    }

    val rightLeafCount = inorder(root.right, count)

    return leftLeafCount + rightLeafCount
}