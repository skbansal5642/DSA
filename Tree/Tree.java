public class Tree {
    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        bt.insertNode(8);
        bt.insertNode(7);
        bt.insertNode(12);
        bt.insertNode(15);
        bt.insertNode(2);
        bt.insertNode(5);
        
        bt.printTree();
    }
}

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    
    Node root;
    
    public Node insert(Node root, int data) {
        
        if (root == null) {
            root = new Node(data);
        } else {
            if (data < root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }
    
    public void insertNode(int data) {
        this.root = insert(this.root, data);
    }
    
    public void printTree() {
        System.out.println("In-order:-");
        inorderTrav(this.root);
        System.out.println();
        System.out.println("Pre-order:-");
        preorderTrav(this.root);
        System.out.println();
        System.out.println("Post-order:-");
        postorderTrav(this.root);
    }
    
    public void inorderTrav(Node root) {
        if (root != null) {
            inorderTrav(root.left);
            System.out.print(root.data + ", ");
            inorderTrav(root.right);
        }
    }
    
    public void preorderTrav(Node root) {
        if (root != null) {
            System.out.print(root.data + ", ");
            preorderTrav(root.left);
            preorderTrav(root.right);
        }
    }
    
    public void postorderTrav(Node root) {
        if (root != null) {
            postorderTrav(root.left);
            postorderTrav(root.right);
            System.out.print(root.data + ", ");
        }
    }
}