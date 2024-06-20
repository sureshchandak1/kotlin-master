package binaryTrees

import printArray
import java.util.*

/**
 *    https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *    https://www.geeksforgeeks.org/problems/level-order-traversal/1
 *    Time Complexity: O(N),  where N is the number of nodes in the binary tree
 *    Space Complexity: O(N), use queue
 */
fun main() {
    val root: TreeNode? = buildTree()

    println("Printing the level order traversal")
    printArray(levelOrder2(root))

    val result = levelOrder1(root)
    printResult(result)
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

private fun levelOrder1(root: TreeNode?): MutableList<MutableList<Int>> {

    val ans: MutableList<MutableList<Int>> = ArrayList()

    if (root == null) {
        return ans
    }

    val q: Queue<TreeNode?> = LinkedList()

    q.add(root)
    q.add(null)

    var levelList: MutableList<Int> = ArrayList()
    while (!q.isEmpty()) {
        // remove from queue
        val top: TreeNode? = q.remove()

        if (top == null) {
            ans.add(levelList)
            levelList = ArrayList()
            if (!q.isEmpty()) {
                q.add(null)
            }
        }
        else {
            // add in list
            levelList.add(top.data)

            //left
            if (top.left != null) {
                q.add(top.left)
            }

            // right
            if (top.right != null) {
                q.add(top.right)
            }
        }

    }

    return ans
}

private fun levelOrder2(root: TreeNode?): ArrayList<Int> {

    val ans = ArrayList<Int>()

    if (root == null) {
        return ans
    }

    val q: Queue<TreeNode> = LinkedList()

    // add root in queue
    q.add(root)

    while (!q.isEmpty()) {

        // remove from queue
        val temp: TreeNode = q.remove()

        // store in ans list
        ans.add(temp.data)

        // left
        if (temp.left != null) {
            q.add(temp.left)
        }

        // right
        if (temp.right != null) {
            q.add(temp.right)
        }
    }

    return ans
}

private fun printResult(result: MutableList<MutableList<Int>>) {
    print("[ ")
    for ((i, level: MutableList<Int>) in result.withIndex()) {
        print("{")
        for ((index, data) in level.withIndex()) {
            print(data)
            if (index < level.size - 1) {
                print(", ")
            }
        }
        print("}")
        if (i < result.size - 1) {
            print(", ")
        }
    }
    print(" ]")
    println()
}










