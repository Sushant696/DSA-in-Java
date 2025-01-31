
public class BST {

    // *first making the node which will be individual element of the bst
    public static class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
//* this is what each node will have when newly create before updating 
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    Node createBST(Node root, int data) {
        // steps 
        //  Check if the root is empty, if yes then create new node and return otherwise proceed
        if (root == null) {
            return new Node(data);
        }
        // insert new data as the root is root.left
        if (data < root.data) {
            root.left = createBST(root.left, data);
        } else if (data > root.data) {
            root.right = createBST(root.right, data);
        } else {
            return root;
        }
        return root;
    }

    Node deleteNode(Node root, int target) {

        Node parent = findParent(root, root.data);
        Node current = root;
        while (current != null && current.data != target) {
            if (current.data < target) {

            }
            if (current != null && current.left == null && current.right == null) {
                if (parent == null) {
                    System.out.println("Tree is now empty.");
                } else if (parent.left == current) {
                    parent.left = null;
                } else if (parent.right == current) {
                    parent.right = null;
                }
                System.out.println("Node deleted.");
            } else {
                System.out.println("Node not found or not a leaf.");
            }

        }
        return root;

    }

    Node findParent(Node root, int target) {
        Node parent = null;
        Node current = root;

        while (current != null) {
            if (current.data == target) {
                break;
            }

            parent = current;

            if (target < current.data) {
                current = current.left; // Go to the left subtree
            } else {
                current = current.right; // Go to the right subtree
            }
        }

        return parent;

    }

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = null;
        bst.createBST(root, 12);
        bst.createBST(root, 21);
        bst.createBST(root, 13);
        bst.createBST(root, 31);
        bst.createBST(root, 96);

    }

}
