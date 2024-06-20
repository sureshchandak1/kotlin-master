package lecture067_Tree_Interview_Questions_Day5

import lecture062_Tree_Introduction.TreeNode
import java.util.*

/*
*   https://www.geeksforgeeks.org/problems/burning-tree/1
* */
fun main() {

}

// key = node, value = parent node
private val nodeToParent: MutableMap<TreeNode?, TreeNode?> = HashMap<TreeNode?, TreeNode?>()

private fun minTime(root: TreeNode, target: Int): Int {

    val targetNode: TreeNode? = createParentMapping(root, target)

    val ans = burnTree(targetNode)

    return ans
}

private fun burnTree(root: TreeNode?): Int {

    val visited: MutableMap<TreeNode?, Boolean> = HashMap<TreeNode?, Boolean>()

    val q: Queue<TreeNode?> = LinkedList<TreeNode?>()
    q.add(root)
    visited[root] = true

    var ans = 0

    while (!q.isEmpty()) {

        var flag = false // node add in queue or not
        val size = q.size

        for (i in 0..< size) {
            val temp: TreeNode? = q.remove()

            if (temp?.left != null && !visited.containsKey(temp.left)) {
                flag = true
                visited[temp.left] = true
                q.add(temp.left)
            }

            if (temp?.right != null && !visited.containsKey(temp.right)) {
                flag = true
                visited[temp.right] = true
                q.add(temp.right)
            }

            if (nodeToParent[temp] != null && !visited.containsKey(nodeToParent[temp])) {
                flag = true
                visited[nodeToParent[temp]] = true
                q.add(nodeToParent[temp])
            }
        }

        if (flag) {
            ans++
        }
    }

    return ans
}

private fun createParentMapping(root: TreeNode, target: Int): TreeNode? {

    var targetNode: TreeNode? = null

    val q: Queue<TreeNode> = LinkedList()
    q.add(root)
    nodeToParent[root] = null

    while (!q.isEmpty()) {
        val temp: TreeNode = q.remove()

        if (temp.data == target) {
            targetNode = temp
        }

        if (temp.left != null) {
            nodeToParent[temp.left] = temp
            q.add(temp.left)
        }

        if (temp.right != null) {
            nodeToParent[temp.right] = temp
            q.add(temp.right)
        }
    }

    return targetNode
}