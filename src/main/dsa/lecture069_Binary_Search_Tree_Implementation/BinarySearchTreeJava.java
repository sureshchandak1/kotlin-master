package lecture069_Binary_Search_Tree_Implementation;

import lecture062_Tree_Introduction.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeJava {

    public static void main(String[] args) {
        TreeNode root = null;

        System.out.println("Enter data to create BST");
        root = takeInput(root);

        System.out.println("Printing the BST");
        levelOrderTraversal(root);

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.println("Maximum: " + maximum(root).getData());
        System.out.println("Minimum: " + minimum(root).getData());

        deleteFromBST(root, 50);

        System.out.println("Printing the BST");
        levelOrderTraversal(root);

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.println("Maximum: " + maximum(root).getData());
        System.out.println("Minimum: " + minimum(root).getData());
    }

    private static TreeNode insertIntoBST(TreeNode root, int d) {

        // Base case
        if (root == null) {
            root = new TreeNode(d);
            return root;
        }

        if (d > root.getData()) {
            // insert into right part
            root.setRight(insertIntoBST(root.getRight(), d));
        } else {
            // insert into left part
            root.setLeft(insertIntoBST(root.getLeft(), d));
        }

        return root;
    }

    private static TreeNode takeInput(TreeNode root) {
        Scanner scanner = new Scanner(System.in);

        int data = 0;
        data = scanner.nextInt();

        while (data != -1) {
            root = insertIntoBST(root, data);
            data = scanner.nextInt();
        }

        return root;
    }

    private static TreeNode deleteFromBST(TreeNode root, int deleteData) {

        // Base case
        if (root == null) {
            return null;
        }

        if (root.getData() == deleteData) {
            // 0 child
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            }

            // 1 child
            // left child
            if (root.getLeft() != null && root.getRight() == null) {
                return root.getLeft();
            }

            // right child
            if (root.getLeft() == null && root.getRight() != null) {
                return root.getRight();
            }

            // 2 child
            if (root.getLeft() != null && root.getRight() != null) {
                int mini = minimum(root.getRight()).getData();
                root.setData(mini);
                root.setRight(deleteFromBST(root.getRight(), mini));
                return root;
            }

        } else if (root.getData() > deleteData) {
            root.setLeft(deleteFromBST(root.getLeft(), deleteData));
            return root;
        } else {
            root.setRight(deleteFromBST(root.getRight(), deleteData));
            return root;
        }

        return root;
    }

    private static TreeNode minimum(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        while (curr.getLeft() != null) {
            curr = curr.getLeft();
        }
        return curr;
    }

    private static TreeNode maximum(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        while (curr.getRight() != null) {
            curr = curr.getRight();
        }
        return curr;
    }

    private static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode temp = q.remove();

            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {

                System.out.print(temp.getData() + "  ");

                if (temp.getLeft() != null) {
                    q.add(temp.getLeft());
                }

                if (temp.getRight() != null) {
                    q.add(temp.getRight());
                }
            }
        }
    }

    private static void inorder(TreeNode root) {
        // L N R
        // Base case
        if (root == null) {
            return;
        }

        inorder(root.getLeft());

        System.out.print(root.getData() + "  ");

        inorder(root.getRight());
    }

    private static void preorder(TreeNode root) {
        // N L R
        // Base case
        if (root == null) {
            return;
        }

        System.out.print(root.getData() + "  ");

        preorder(root.getLeft());

        preorder(root.getRight());
    }

    private static void postorder(TreeNode root) {
        // L R N
        // Base case
        if (root == null) {
            return;
        }

        postorder(root.getLeft());

        postorder(root.getRight());

        System.out.print(root.getData() + "  ");
    }

}

