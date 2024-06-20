package binaryTrees

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

/**
 *          Maximum Depth of Binary Tree (Height of Binary Tree)
 *   https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *   https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
 *   Time Complexity: O(N),  where N is the number of nodes in the Binary Tree
 *   Space Complexity: O(N)
 */
fun main() {
    val root: TreeNode? = buildTree()

    println("Max Depth: ${getHeight1(root)}")
    println("Max Depth: ${getHeight2(root)}")
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

// max depth
private fun getHeight1(root: TreeNode?): Int {

    if (root == null) {
        return 0
    }

    var level = 0
    val q: Queue<TreeNode> = LinkedList()

    q.add(root)

    while (!q.isEmpty()) {

        val size = q.size

        for (i in 0 ..< size) {
            // Get the front node in the queue
            val temp = q.poll()

            // left
            if (temp.left != null) {
                q.add(temp.left)
            }

            // right
            if (temp.right != null) {
                q.add(temp.right)
            }
        }

        // Increment level
        // move to the next level
        level++
    }

    return level
}

private fun getHeight2(root: TreeNode?) : Int {

    // Base case
    if (root == null) {
        return 0
    }

    // left
    val left = getHeight2(root.left)

    // right
    val right = getHeight2(root.right)

    val height = max(left, right) + 1

    return height
}




