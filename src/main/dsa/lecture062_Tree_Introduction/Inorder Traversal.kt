package lecture062_Tree_Introduction

import java.util.*

/*
*      L N R
* */
fun main() {
    var root: TreeNode? = null

    root = buildTree()

    println("Inorder Traversal")
    inorder(root)
}

private fun buildTree(): TreeNode? {

    println("Enter the data: ")
    val data: Int = readln().toInt()

    val root = TreeNode(data)

    if (data == -1) {
        return null
    }

    println("Enter data for inserting in left of $data ")
    root.left = buildTree()

    println("Enter data for inserting in right of $data ")
    root.right = buildTree()

    return root

}

private fun inorder(root: TreeNode?) {
    // L N R

    if (root == null) {
        return
    }

    inorder(root.left) // L

    print("${root.data} ") // N

    inorder(root.right) // R
}