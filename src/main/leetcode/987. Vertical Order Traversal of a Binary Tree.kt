import lecture062_Tree_Introduction.TreeNode
import java.util.*


/**
 *   https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 */
fun main() {

}

private fun verticalTraversal(root: TreeNode?): List<List<Int>> {

    val nodes = TreeMap<Int, TreeMap<Int, PriorityQueue<Int> > >()
    val q: Queue<PairFirst> = LinkedList()
    val ans: MutableList<MutableList<Int>> = ArrayList()

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

            nodes.getOrPut(hd) { TreeMap() }.getOrPut(lvl) { PriorityQueue() }.add(node.data)

            if (node.left != null) {
                q.add(PairFirst(node.left!!, PairSecond(hd-1, lvl+1)))
            }
            if (node.right != null) {
                q.add(PairFirst(node.right!!, PairSecond(hd+1, lvl+1)))
            }

        }
    }

    for (i in nodes.entries) {
        val list = ArrayList<Int>()
        for (j in i.value.entries) {
            while (!j.value.isEmpty()) {
                list.add(j.value.poll())
            }

        }

        ans.add(list)
    }

    return ans

}

private class PairFirst(node: TreeNode, pair: PairSecond) {

    var node: TreeNode? = null
    var pair: PairSecond

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

private fun buildTree(str: String): TreeNode? {

    if (str.isEmpty() || str[0] == 'N') {
        return null
    }

    val ip = str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    // Create the root of the tree
    val root = TreeNode(ip[0].toInt())

    // Push the root to the queue
    val queue: Queue<TreeNode> = LinkedList()

    queue.add(root)

    // Starting from the second element
    var i = 1
    while (queue.size > 0 && i < ip.size) {
        // Get and remove the front of the queue
        val currNode = queue.peek()
        queue.remove()

        // Get the current node's value from the string
        var currVal = ip[i]

        // If the left child is not null
        if (currVal != "N") {
            // Create the left child for the current node
            currNode.left = TreeNode(currVal.toInt())
            // Push it to the queue
            queue.add(currNode.left)
        }


        // For the right child
        i++
        if (i >= ip.size) break

        currVal = ip[i]

        // If the right child is not null
        if (currVal != "N") {
            // Create the right child for the current node
            currNode.right = TreeNode(currVal.toInt())
            // Push it to the queue
            queue.add(currNode.right)
        }

        i++
    }

    return root
}









