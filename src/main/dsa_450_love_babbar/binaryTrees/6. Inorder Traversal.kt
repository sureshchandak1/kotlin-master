package binaryTrees

import java.util.*

fun main() {
    val root: TreeNode? = TreeBuilder.buildTree()

    println("Inorder Traversal")
    inorder(root)
    println()
    inorderIterative(root)
}

// L N R = left, node, right
// Recursive
private fun inorder(root: TreeNode?) {

    // Base case
    if (root == null) {
        return
    }

    inorder(root.left) // L

    print("${root.data}  ") // N

    inorder(root.right) // R
}

// Iterative
private fun inorderIterative(root: TreeNode?) {

    val stack: Stack<TreeNode> = Stack<TreeNode>()

    var curr: TreeNode? = root // start from the root node (set current node to the root node)

    // if the current node is null and the stack is also empty, we are done
    while (!stack.empty() || curr != null) {
        // if the current node exists, push it into the stack (defer it) and move to its left child
        if (curr != null) {
            stack.push(curr)
            curr = curr.left
        } else {
            // otherwise, if the current node is null, pop an element from
            // the stack, print it, and finally set the current node to its
            // right child
            curr = stack.pop()
            print("${curr.data}  ")

            curr = curr.right
        }
    }
}




