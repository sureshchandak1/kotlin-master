package lecture062_Tree_Introduction

import java.util.*


fun main() {
    var root: TreeNode? = null

    root = buildTree()

    println("Printing the reverse level order traversal output")
    reverseLevelOrder(root!!)
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

private fun reverseLevelOrder(node: TreeNode): ArrayList<Int> {

    val ans = ArrayList<Int>()

    val s: Stack<TreeNode> = Stack()
    val q: Queue<TreeNode> = LinkedList()
    q.add(node)

    var temp: TreeNode
    while (!q.isEmpty()) {

        temp = q.remove()
        s.push(temp)

        if (temp.right != null) {
            q.add(temp.right)
        }

        if (temp.left != null) {
            q.add(temp.left)
        }
    }

    while (!s.empty()) {
        temp = s.pop()
        ans.add(temp.data)
    }

    return ans
}