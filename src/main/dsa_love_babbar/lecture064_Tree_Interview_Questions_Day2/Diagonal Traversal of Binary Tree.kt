package lecture064_Tree_Interview_Questions_Day2

import lecture062_Tree_Introduction.TreeNode
import java.util.*


/*
*  https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
* */
fun main() {
    val root = TreeNode(8)
    root.left = TreeNode(3)
    root.right = TreeNode(10)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(6)
    root.right!!.right = TreeNode(14)
    root.right!!.right!!.left = TreeNode(13)
    root.left!!.right!!.left = TreeNode(4)
    root.left!!.right!!.right = TreeNode(7)

    diagonalPrint(root)
}

private fun diagonalPrintUtil(root: TreeNode?, d: Int, diagonalPrint: TreeMap<Int?, Vector<Int?>?>) {

    // Base case
    if (root == null) return


    // get the list at the particular d value
    var k: Vector<Int?>? = diagonalPrint[d]


    // k is null then create a
    // vector and store the data
    if (k == null) {
        k = Vector()
        k.add(root.data)
    } else {
        k.add(root.data)
    }


    // Store all nodes of same line
    // together as a vector
    diagonalPrint[d] = k


    // Increase the vertical distance
    // if left child
    diagonalPrintUtil(root.left, d + 1, diagonalPrint)


    // Vertical distance remains
    // same for right child
    diagonalPrintUtil(root.right, d, diagonalPrint)
}

private fun diagonalPrint(root: TreeNode?) {
    // create a map of vectors
    // to store Diagonal elements

    val diagonalPrint: TreeMap<Int?, Vector<Int?>?> = TreeMap<Int?, Vector<Int?>?>()
    diagonalPrintUtil(root, 0, diagonalPrint)

    println("Diagonal Traversal of Binary Tree")
    for ((_, value) in diagonalPrint) {
        println(value)
    }
}

private fun diagonalPrint2(root: TreeNode?) {

    if (root == null) return

    val map = TreeMap<Int, MutableList<Int>>()

    val q: Queue<TNode> = LinkedList()
    q.add(TNode(root, 0))

    while (!q.isEmpty()) {

        val curr = q.poll()
        map.putIfAbsent(curr.level, ArrayList())
        map[curr.level]?.add(curr.node!!.data)

        if (curr.node!!.left != null) {
            q.add(TNode(curr.node!!.left, curr.level + 1))
        }

        if (curr.node!!.right != null) {
            q.add(TNode(curr.node!!.right, curr.level))
        }
    }

    for ((k) in map) {
        val l: List<Int> = map[k]!!
        val size = l.size

        for (i in l.indices) {
            print(l[i])
            print(" ")
        }
        println("")
    }
    return
}


private class TNode(var node: TreeNode?, var level: Int)


