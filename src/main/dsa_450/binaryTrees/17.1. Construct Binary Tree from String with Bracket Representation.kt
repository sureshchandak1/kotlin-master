package binaryTrees

import java.util.*

fun main() {
    println("Enter tree string: ")
    val treeString = readln()

    val root = parseTree(treeString)
    preorderIterative(root)

}

// Depth-First Search (DFS)
private fun parseTree(str: String): TreeNode? {

    if (str == "") {
        return null
    }

    val leftParenIndex = str.indexOf("(") // Find the position of the first left parenthesis

    // If no parenthesis is found, only a number is present, so create a lone node
    if (leftParenIndex == -1) {
        return TreeNode(str.toInt())
    }

    // Create the root node with the value before the first parenthesis
    val root = TreeNode(str.substring(0, leftParenIndex).toInt())

    // Keep track of the parenthesis balance
    var balance = 0

    // Tracks the start position for the substring to process next
    var subStart = leftParenIndex

    for (i in leftParenIndex ..< str.length) {
        // Update balance when a parenthesis is encountered
        if (str[i] == '(') {
            balance++
        } else if (str[i] == ')') {
            balance--
        }

        // When balance becomes zero, we have a balanced subpart of the string
        if (balance == 0) {
            if (subStart == leftParenIndex) {
                // This substring corresponds to the left child
                root.left = parseTree(str.substring(subStart + 1, i))
                // Update the start position for the right child
                subStart = i + 1
            } else {
                // This substring corresponds to the right child, if present
                root.right = parseTree(str.substring(subStart + 1, i))
            }
        }
    }

    return root
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















