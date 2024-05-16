package binaryTrees

/**
 *     https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1
 *     Time Complexity: O(N)
 *     Space Complexity: O(H)
 */
fun main() {
    val root = TreeBuilder.buildTree()

    val obj = BinaryTreeToDLL()
    val head = obj.bToDLL(root)
    obj.print(head)
}

private class BinaryTreeToDLL {

    private var head: TreeNode? = null
    private var tail: TreeNode? = null

    fun bToDLL(root: TreeNode?): TreeNode? {
        binaryTreeToDLL(root)
        return head
    }

    private fun binaryTreeToDLL(root: TreeNode?) {

        // base case
        if (root == null) {
            return
        }

        binaryTreeToDLL(root.left) // left

        if (tail == null) {
            head = root
        } else {
            root.left = tail
            tail?.right = root
        }
        tail = root

        binaryTreeToDLL(root.right) // right
    }

    fun print(head: TreeNode?) {
        if (head == null) {
            println("Linked list is empty")
        }

        var curr = head
        while (curr != null) {
            print("${curr.data}  ")
            curr = curr.right
        }
    }
}





