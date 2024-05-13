package binaryTrees

import java.util.*

fun main() {
    val root: TreeNode? = TreeBuilder.buildTree()

    println("Postorder Traversal")
    postorder(root)
    println()
    postorderIterative(root)
}

// L R N
private fun postorder(root: TreeNode?) {

    // Base case
    if (root == null) {
        return
    }

    postorder(root.left) // L

    postorder(root.right) // R

    print("${root.data}  ") // N
}

private fun postorderIterative(root: TreeNode?) {

    if (root == null) return

    val stack: Stack<TreeNode> = Stack<TreeNode>()
    stack.push(root)

    val out = Stack<Int>() // create another stack to store postorder traversal

    while (!stack.empty()) {
        // pop a node from the stack and push the data into the output stack
        val curr: TreeNode = stack.pop()
        out.push(curr.data)

        // push the left and right child of the popped node into the stack
        if (curr.left != null) {
            stack.push(curr.left)
        }

        if (curr.right != null) {
            stack.push(curr.right)
        }
    }

    // print postorder traversal
    while (!out.empty()) {
        print("${out.pop()}  ")
    }
}



