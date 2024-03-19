package lecture064_Tree_Interview_Questions_Day2

import lecture062_Tree_Introduction.TreeNode
import java.util.*

/*
*   https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
* */
fun main() {

}

private fun bottomView(root: TreeNode?): List<Int> {
    val ans: MutableList<Int> = ArrayList()

    if (root == null) {
        return ans
    }

    val nodes: MutableMap<Int, Int> = TreeMap()
    val q: Queue<BottomViewPair> = LinkedList()

    q.add(BottomViewPair(root, 0))

    while (!q.isEmpty()) {
        val temp = q.remove()

        val node: TreeNode = temp.node!!
        val hd = temp.horizontalDistance

        nodes[hd] = node.data

        if (node.left != null) {
            q.add(BottomViewPair(node.left, hd - 1))
        }
        if (node.right != null) {
            q.add(BottomViewPair(node.right, hd + 1))
        }
    }

    for ((_, value) in nodes) {
        ans.add(value)
    }

    return ans
}

private class BottomViewPair(node: TreeNode?, horizontalDistance: Int) {

    var node: TreeNode? = null
    var horizontalDistance: Int = 0

    init {
        this.node = node
        this.horizontalDistance = horizontalDistance
    }
}