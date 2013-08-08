package utils;

/**
 *  Utility to work with binary trees.
 *
 * @author jtan
 * @version 8/8/13
 */

public class BinaryTreeUtil {

    /** Returns the height of current node in binary tree.  -1 is returned if there is an error. In a BST, this will return the max
     *  number of child nodes on either the left or right side of the current node.
     *
     * @param head
     * @param currentNode
     * @return
     */
    public static int getHeight(Node head, Node currentNode) {

        if (head == null || currentNode == null) {
            return -1;
        }

        int leftHeight = getHeight(head, currentNode.getLeft());
        int rightHeight = getHeight(head, currentNode.getRight());

        if (leftHeight == -1 || rightHeight == -1) {
            return 0;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     *  Checks to see if all child nodes are balanced under the current node.
     *
     * @param head
     * @return
     */
    public static boolean isBalanced(Node head, Node currentNode) {
        return getHeight(head, currentNode) == -1;
    }

}