package lecture064_Tree_Interview_Questions_Day2

import lecture062_Tree_Introduction.TreeNode
import java.util.*

/*
*   https://www.geeksforgeeks.org/problems/zigzag-tree-traversal/1
*
* */

fun main() {

}

private fun zigZagTraversal(root: TreeNode?): ArrayList<Int> {

    val result: ArrayList<Int> = ArrayList<Int>()

    if (root == null) {
        return result
    }

    val q: Queue<TreeNode> = LinkedList()
    q.add(root)

    var leftToRight = true

    while (!q.isEmpty()) {
        val size = q.size

        val ans = arrayOfNulls<Int>(size)

        for (i in 0..< size) {

            val temp: TreeNode = q.remove()

            val index = if (leftToRight) i else size - i - 1
            ans[index] = temp.data

            if (temp.left != null) {
                q.add(temp.left)
            }
            if (temp.right != null) {
                q.add(temp.right)
            }
        }

        leftToRight = !leftToRight

        for (value in ans) {
            result.add(value!!)
        }
    }

    return result
}