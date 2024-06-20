package lecture062_Tree_Introduction

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() {
    var root: TreeNode? = null

    root = buildTree()

    println("Printing the level order traversal output")
    levelOrderTraversal1(root ?: TreeNode(-1))
    levelOrderTraversal2(root ?: TreeNode(-1))
    println("Printing the reverse level order traversal output")
    reverseLevelOrderTraversal1(root ?: TreeNode(-1))
}

// Creating tree
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

private fun levelOrderTraversal1(root: TreeNode) {
    val q: Queue<TreeNode> = LinkedList()
    q.add(root)

    while (!q.isEmpty()) {
        val temp = q.remove()
        print("${temp.data} ")

        if (temp.left != null) {
            q.add(temp.left)
        }

        if (temp.right != null) {
            q.add(temp.right)
        }
    }

    println()
}

private fun levelOrderTraversal2(root: TreeNode) {
    val q: Queue<TreeNode?> = LinkedList()
    q.add(root)
    q.add(null) // null - separator

    while (!q.isEmpty()) {
        val temp = q.remove()

        if (temp == null) {
            println()
            if (!q.isEmpty()) {
                q.add(null)
            }

        } else {
            print("${temp.data} ")

            if (temp.left != null) {
                q.add(temp.left)
            }

            if (temp.right != null) {
                q.add(temp.right)
            }
        }
    }

}

private fun reverseLevelOrderTraversal1(root: TreeNode) {

    val s: Stack<TreeNode> = Stack()
    val q: Queue<TreeNode> = LinkedList()
    q.add(root)

    var temp: TreeNode
    while (!q.isEmpty()) {
        temp = q.remove()
        s.push(temp)

        if (temp.left != null) {
            q.add(temp.left)
        }

        if (temp.right != null) {
            q.add(temp.right)
        }
    }

    while (!s.empty()) {
        temp = s.pop()
        print("${temp.data} ")
    }

}