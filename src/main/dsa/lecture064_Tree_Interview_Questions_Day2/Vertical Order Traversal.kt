package lecture064_Tree_Interview_Questions_Day2

import lecture062_Tree_Introduction.TreeNode
import java.util.*

/*
*  https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
* */

fun main() {

}

private fun verticalOrderTraversal(root: TreeNode?): ArrayList<Int> {

    val nodes = TreeMap<Int, TreeMap<Int, MutableList<Int>>>()
    val q: Queue<PairFirst> = LinkedList()
    val ans = ArrayList<Int>()

    if (root == null) {
        return ans
    }

    q.add(PairFirst(root, PairSecond(0, 0)))

    while (!q.isEmpty()) {

        val temp = q.remove()

        val node: TreeNode? = temp.node
        val hd: Int = temp.pair.horizontalDistance
        val lvl: Int = temp.pair.level

        node?.let {

            //nodes[hd][lvl] = node.data
            nodes.getOrPut(hd) { TreeMap() }.getOrPut(lvl) { mutableListOf() }.add(node.data)

            if (node.left != null) {
                q.add(PairFirst(root.left!!, PairSecond(hd-1, lvl+1)))
            }
            if (node.right != null) {
                q.add(PairFirst(root.right!!, PairSecond(hd+1, lvl+1)))
            }
        }

    }

    for (i in nodes) {
        for (j in i.value) {
            for (k in j.value) {
                ans.add(k)
            }
        }
    }

    return ans
}

private class PairFirst(node: TreeNode, pair: PairSecond) {

    var node: TreeNode? = null
    val pair: PairSecond

    init {
        this.node = node
        this.pair = pair
    }
}

private class PairSecond(horizontalDistance: Int, level: Int) {

    var horizontalDistance: Int = 0
    var level: Int = 0

    init {
        this.horizontalDistance = horizontalDistance
        this.level = level
    }
}