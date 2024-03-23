package lecture069_Binary_Search_Tree_Implementation

import lecture062_Tree_Introduction.TreeNode
import java.util.*

object BinarySearchTree {

    @JvmStatic
    fun main(args: Array<String>) {
        var root: TreeNode? = null

        println("Enter data to create BST")
        root = takeInput(root)

        println("Printing the BST")
        levelOrderTraversal(root)

        print("Inorder: ")
        inorder(root)
        println()

        print("Preorder: ")
        preorder(root)
        println()

        print("Postorder: ")
        postorder(root)
        println()

        println("Maximum: " + maximum(root))
        println("Minimum: " + minimum(root))

        deleteFromBST(root, 50)

        println("Printing the BST")
        levelOrderTraversal(root)

        print("Inorder: ")
        inorder(root)
        println()

        print("Preorder: ")
        preorder(root)
        println()

        print("Postorder: ")
        postorder(root)
        println()

        println("Maximum: " + maximum(root))
        println("Minimum: " + minimum(root))
    }

    private fun insertIntoBST(root: TreeNode?, d: Int): TreeNode {

        // Base case
        var root = root
        if (root == null) {
            root = TreeNode(d)
            return root
        }

        if (d > root.data) {
            // insert into right part
            root.right = insertIntoBST(root.right, d)
        } else {
            // insert into left part
            root.left = insertIntoBST(root.left, d)
        }

        return root
    }

    private fun takeInput(root: TreeNode?): TreeNode? {

        var root = root
        val scanner = Scanner(System.`in`)

        var data = 0
        data = scanner.nextInt()

        while (data != -1) {
            root = insertIntoBST(root, data)
            data = scanner.nextInt()
        }

        return root
    }

    private fun deleteFromBST(root: TreeNode?, deleteData: Int): TreeNode? {

        // Base case
        if (root == null) {
            return null
        }

        if (root.data == deleteData) {
            // 0 child
            if (root.left == null && root.right == null) {
                return null
            }

            // 1 child
            // left child
            if (root.left != null && root.right == null) {
                return root.left
            }

            // right child
            if (root.left == null && root.right != null) {
                return root.right
            }

            // 2 child
            if (root.left != null && root.right != null) {
                val mini = minimum(root.right)
                root.data = mini
                root.right = deleteFromBST(root.right, mini)
                return root
            }
        } else if (root.data > deleteData) {
            root.left = deleteFromBST(root.left, deleteData)
            return root
        } else {
            root.right = deleteFromBST(root.right, deleteData)
            return root
        }

        return root
    }

    private fun minimum(root: TreeNode?): Int {
        root?.let {
            var curr: TreeNode? = root
            while (curr!!.left != null) {
                curr = curr.left
            }
            return curr.data
        } ?: return -1
    }

    private fun maximum(root: TreeNode?): Int {
        root?.let {
            var curr: TreeNode? = root
            while (curr!!.right != null) {
                curr = curr.right
            }
            return curr.data
        } ?: return -1
    }

    private fun levelOrderTraversal(root: TreeNode?) {
        if (root == null) {
            return
        }

        val q: Queue<TreeNode?> = LinkedList()
        q.add(root)
        q.add(null)

        while (!q.isEmpty()) {
            val temp = q.remove()

            if (temp == null) {
                println()
                if (!q.isEmpty()) {
                    q.add(null)
                }
            } else {
                print(temp.data.toString() + " ")

                if (temp.left != null) {
                    q.add(temp.left)
                }

                if (temp.right != null) {
                    q.add(temp.right)
                }
            }
        }
    }

    private fun inorder(root: TreeNode?) {
        // L N R
        // Base case
        if (root == null) {
            return
        }

        inorder(root.left)

        print(root.data.toString() + "  ")

        inorder(root.right)
    }

    private fun preorder(root: TreeNode?) {
        // N L R
        // Base case
        if (root == null) {
            return
        }

        print(root.data.toString() + "  ")

        preorder(root.left)

        preorder(root.right)
    }

    private fun postorder(root: TreeNode?) {
        // L R N
        // Base case
        if (root == null) {
            return
        }

        postorder(root.left)

        postorder(root.right)

        print(root.data.toString() + "  ")
    }
}





