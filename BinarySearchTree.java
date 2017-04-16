package assignmentfive;

import java.io.*;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {

    protected TreeNode<E> root;
    protected int size = 0;

    /**
     * Create a default binary tree
     */
    public BinarySearchTree() {
    } // empty constructor

    /**
     * Create a binary tree from an array of objects
     */
    public BinarySearchTree(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        } // for
    } // BinarySearchTree

    public boolean search(E e) {
        return false;
    }

    /**
     * Returns true if the element is in the tree
     */
    public boolean search(E e, int[] arrayAdd) {
        arrayAdd[0] = 1;
        TreeNode<E> current = root; // Start from the root
        int counter = 0;
        while (current != null) {
            counter++;
            arrayAdd[0] = counter;
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else // element matches current.element
            {
                return true; // Element is found
            }

        }
        return false;
    }

    /**
     * Insert element o into the binary tree Return true if the element is
     * inserted successfully. Uses an iterative algorithm
     */
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e); // Create a new root
        } else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Duplicate node not inserted
                } // else
            } // while
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            } // else
        } // if
        size++;
        return true; // Element inserted
    } // insert

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<E>(e);
    } // creatNewNode

    /**
     * Inorder traversal from the root
     */
    public void inorder() {
        inorder(root);
    }//inorder

    /**
     * Inorder traversal from a subtree
     */
    protected void inorder(TreeNode<E> root) {
        if (root == null) {
            return;
        } // if
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    } //inorder protected

    /**
     * Postorder traversal from the root
     */
    public void postorder() {
        postorder(root);
    } // postorder

    /**
     * Postorder traversal from a subtree
     */
    protected void postorder(TreeNode<E> root) {
        if (root == null) {
            return;
        } // if
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    } // if

    /**
     * Preorder traversal from the root
     */
    public void preorder() {
        preorder(root);
    } // preorder

    /**
     * Preorder traversal from a subtree
     */
    protected void preorder(TreeNode<E> root) {
        if (root == null) {
            return;
        } //if
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    } // preorder

    /**
     * Inner class tree node
     */
    public static class TreeNode<E extends Comparable<E>> {

        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        } // treeNode
    } // big tree node

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return size;
    } //get Size

    /**
     * Returns the root of the tree
     */
    public TreeNode getRoot() {
        return root;
    } // get Root

    /**
     * Returns an ArrayList containing elements in the path from the root
     * leading to the specified element, returns an empty ArrayList if no such
     * element exists.
     */
    public ArrayList<E> path(E e) {
        java.util.ArrayList<E> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root
        //implement the code here as in search method.
        if (search(e) == true) {
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    list.add(current.element);
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    list.add(current.element);
                    current = current.right;
                } else // element matches current.element
                {
                    break; // Element is found
                } //to break
            } // while
        } // if
        return list;
    } // path


    /* Returns the number of leaf nodes in this tree, returns 0 if tree is empty*/
    public int getNumberOfLeaves() {
        return getNumberofLeaves(root);
    } // getNumberOfLeaves

    private int getNumberofLeaves(TreeNode<E> root) {
        if (root == null) {
            return 0;
        } // if
        if (root.left == null && root.right == null) {
            return 1;
        } // if
        return getNumberofLeaves(root.left) + getNumberofLeaves(root.right);
    }//getNumberOfLeaves private

    /* Returns an ArrayList containing all elements in preorder of the specified element’s left sub-tree, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> leftSubTree(E e) {
        return leftSubTree(e, this.root);
    }//leftSubTree

    protected ArrayList<E> leftSubTree(E e, TreeNode<E> root) {
        ArrayList<E> left = new ArrayList<E>();
        TreeNode<E> current = root; // Start from the root
        if (search(e) == true) {
            while (current.element != e) {
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                }//else if
            } // while

            while (current != null) {
                left.add(current.element);
                current = current.left;
            } //while
        } // if
        return left;

    }//leftSubTree

    /* Returns an ArrayList containing all elements in preorder of the specified element’s right sub-tree, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> rightSubTree(E e) {
        return rightSubTree(e, this.root);
    } //rightSubTree

    protected ArrayList<E> rightSubTree(E e, TreeNode<E> root) {
        ArrayList<E> right = new ArrayList<E>();
        TreeNode<E> current = root; // Start from the root
        if (search(e) == true) {
            while (current.element != e) {
                System.out.println(current.element);
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                } // else if
            } // while

            while (current != null) {
                right.add(current.element);
                current = current.right;
            } //while
        } // if
        return right;

    } //rightSubTree

    /* Returns true if this BinarySearchTree is structurally identical to BinarySearchTree tree, otherwise returns false */
    public boolean sameTree(BinarySearchTree tree1, BinarySearchTree tree) {
        if ((tree1 == null) && (tree == null)) {
            return true;
            //different length not tested
        } else if (tree1.root.element.equals(tree.root.element)
                && tree.leftSubTree(tree.root.element).equals(tree1.leftSubTree(tree1.root.element))
                && tree.rightSubTree(tree.root.element).equals(tree1.rightSubTree(tree1.root.element))
                && tree.size == tree1.size) {
            return true;
        } else {
            return false;
        } // else
    } // sameTree

//    /* Returns the inorder predecessor of the specified element, returns null if tree is empty or element 'e' is not in the tree. */
//    public E inorderPredecessor(E e) {
//        //left for you to implement in Lab 7
//    }
    /**
     * Delete an element from the binary tree. Return true if the element is
     * deleted successfully Return false if the element is not in the tree
     */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break; // Element is in the tree pointed by current
            } // else
        } // while
        if (current == null) {
            return false; // Element is not in the tree
        }    // Case 1: current has no left children
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else if (e.compareTo(parent.element) < 0) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            } // else
        } else {
            // Case 2 & 3: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            } // while
            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else // Special case: parentOfRightMost == current
            {
                parentOfRightMost.left = rightMost.left;
            } // else
        } // else
        size--;
        return true; // Element inserted
    } // delete

    /**
     * Obtain an iterator. Use inorder.
     */
    public java.util.Iterator iterator() {
        return inorderIterator();
    } // iterator

    /**
     * Obtain an inorder iterator
     */
    public java.util.Iterator inorderIterator() {
        return new InorderIterator();

    } // inorderIterator

    // Inner class InorderIterator
    class InorderIterator implements java.util.Iterator {
        // Store the elements in a list

        private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        } //inorderiterator

        /**
         * Inorder traversal from the root
         */
        private void inorder() {
            inorder(root);
        } //inorder

        /**
         * Inorder traversal from a subtree
         */
        private void inorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        } //inorder private

        /**
         * Next element for traversing?
         */
        public boolean hasNext() {
            if (current < list.size()) {
                return true;
            } // if
            return false;
        } // hasNext

        /**
         * Get the current element and move cursor to the next
         */
        public Object next() {
            return list.get(current++);
        } //next

        /**
         * Remove the current element and refresh the list
         */
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        } // remove
    } //inOrderIterator

    /**
     * Remove all elements from the tree
     */
    public void clear() {
        root = null;
        size = 0;
    } // clear

} // class
