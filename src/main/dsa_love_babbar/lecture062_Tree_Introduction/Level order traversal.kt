package lecture062_Tree_Introduction

import java.util.*


fun main() {
    var root: TreeNode? = null

    root = buildTree()

    println("Printing the level order traversal output")
    levelOrder(root ?: TreeNode(-1))
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

//Function to return the level order traversal of a tree.
private fun levelOrder(root: TreeNode): ArrayList<Int> {

    val ans = ArrayList<Int>()

    val q: Queue<TreeNode> = LinkedList()
    q.add(root)

    var temp: TreeNode
    while (!q.isEmpty()) {

        temp = q.remove()
        ans.add(temp.data)

        if (temp.left != null) {
            q.add(temp.left)
        }

        if (temp.right != null) {
            q.add(temp.right)
        }
    }

    return ans
}