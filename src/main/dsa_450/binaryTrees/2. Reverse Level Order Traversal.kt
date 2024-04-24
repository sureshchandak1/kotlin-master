package binaryTrees

import printArray
import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/reverse-level-order-traversal/1
 *    Time Complexity: O(N),  where N is the number of nodes in the binary tree
 *    Space Complexity: O(N), use stack & queue
 */
fun main() {
    val root: TreeNode? = buildTree()

    println("Printing the reverse level order traversal")
    printArray(reverseLevelOrder(root))
}

// Create binary tree
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

private fun reverseLevelOrder(node: TreeNode?): ArrayList<Int> {

    val ans = ArrayList<Int>()

    if (node == null) {
        return ans
    }

    val s = Stack<Int>()
    val q: Queue<TreeNode> = LinkedList()

    q.add(node)

    while (!q.isEmpty()) {

        // remove from queue
        val temp: TreeNode = q.remove()

        // add in stack
        s.push(temp.data)

        // right
        if (temp.right != null) {
            q.add(temp.right)
        }

        // left
        if (temp.left != null) {
            q.add(temp.left)
        }
    }

    while (!s.isEmpty()) {
        ans.add(s.pop())
    }

    return ans
}


