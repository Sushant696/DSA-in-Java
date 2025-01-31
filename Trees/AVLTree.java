
public class AVLTree {

    public static class Node {

        Node left;
        Node right;
        int data;
        int height;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = this.right = null;
        }
    }

    Node createBST(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        // * check if the data is small then root so explore in the left side of the bs tree
        // and after finding the null where the data is smaller then the the node that has been called then this execution will complete.
        if (data < root.data) {
            root.left = createBST(root.left, data);

        } else if (data > root.data) {
            // * check if the data is big then root so explore in the left side of the bs tree
            root.right = createBST(root.right, data);
        } else {
            return root;
        }
        root.height = Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = getBalanceFactor(root);

        if (balanceFactor > 1 && data < root.left.data) {
            // left left 

            // apply single right rotation 
            return rightRotation(root);
        }
        if (balanceFactor > 1 && data > root.left.data) {
            // left right 
            // apply left and return right rotation
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        if (balanceFactor < -1 && data > root.right.data) {
            // right right
            // apply sinlge left rotation 
            return leftRotation(root);
        }
        if (balanceFactor < -1 && data < root.right.data) {

            // right left
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }

    Node leftRotation(Node x) {
        Node y = x.left;
        Node t2 = y.right; // temp to store the right part of the tree while adjusting
        y.left = x; // rotating by puting x in the y.left
        x.right = t2;
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        return y;
    }

    Node rightRotation(Node y) {
        Node x = y.left;
        Node t2 = x.right; // temp to store the right part of the tree while adjusting
        x.right = y; // rotating by puting y in the x.right
        y.left = t2;
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    int getBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }

        return getHeight(root.left) - getHeight(root.right);
    }

    int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

}
