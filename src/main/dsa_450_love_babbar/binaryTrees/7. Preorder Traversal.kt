package binaryTrees

import java.util.*

fun main() {
    val root: TreeNode? = TreeBuilder.buildTree()

    println("Preorder Traversal")
    preorder(root)
    println()
    preorderIterative(root)
}

// N L R
private fun preorder(root: TreeNode?) {

    // Base case
    if (root == null) {
        return
    }

    print("${root.data}  ") // N

    preorder(root.left) // L

    preorder(root.right) // R
}

private fun preorderIterative(root: TreeNode?) {

    if (root == null) return

    val stack: Stack<TreeNode> = Stack<TreeNode>()
    stack.push(root)

    while (!stack.empty()) {
        // pop a node from the stack and print it
        val curr: TreeNode = stack.pop()

        print("${curr.data}  ")

        // push the right child of the popped node into the stack
        if (curr.right != null) {
            stack.push(curr.right)
        }

        // push the left child of the popped node into the stack
        if (curr.left != null) {
            stack.push(curr.left)
        }

        // the right child must be pushed first so that the left child
        // is processed first (LIFO order)
    }
}





