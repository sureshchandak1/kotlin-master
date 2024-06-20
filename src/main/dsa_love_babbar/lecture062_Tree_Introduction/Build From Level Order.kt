package lecture062_Tree_Introduction

import java.util.LinkedList
import java.util.Queue

fun main() {
    val root = buildFromLevelOrder()
    levelOrderTraversal(root)
}

private fun buildFromLevelOrder(): TreeNode {

    println("Enter data for root: ")
    val data: Int = readln().toInt()
    val root = TreeNode(data)

    val q: Queue<TreeNode> = LinkedList()
    q.add(root)

    while (!q.isEmpty()) {
        val temp = q.remove()

        println("Enter left node for: ${temp.data}")
        val leftData: Int = readln().toInt()
        if (leftData != -1) {
            temp.left = TreeNode(leftData)
            q.add(temp.left)
        }

        println("Enter right node for: ${temp.data}")
        val rightData: Int = readln().toInt()
        if (rightData != -1) {
            temp.right = TreeNode(rightData)
            q.add(temp.right)
        }
    }

    return root
}

private fun levelOrderTraversal(root: TreeNode) {
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

