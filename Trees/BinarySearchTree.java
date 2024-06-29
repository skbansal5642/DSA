import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

public class BinarySearchTree {
    public static void main(String args[]) {
        TreeOperations bt = new TreeOperations();
        bt.insertNode(8);
        bt.insertNode(5);
        bt.insertNode(12);
        bt.insertNode(2);
        bt.insertNode(4);
        bt.insertNode(3);
        bt.insertNode(6);
        bt.insertNode(10);
        bt.insertNode(14);
        bt.insertNode(13);
        bt.insertNode(15);

        bt.printTree();

        System.out.println();
        // Print height of the tree
        System.out.println("Height of tree: " + bt.getHeightOfTree());
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

class TreeOperations {

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

        // deleteNode(8);

        System.out.println();
        System.out.println("Post-order:-");
        postorderTrav(this.root);

        System.out.println();
        System.out.println("Level-order:-");
        levelOrderTrav();

        System.out.println();
        System.out.println("Print element level wise:-");
        levelWiseTrav();

        System.out.println();
        System.out.println("Left View of Tree:-");
        printLeftView();

        System.out.println();
        System.out.println("Right View of Tree:-");
        printRightView();

        System.out.println();
        System.out.println("Top View of Tree:-");
        printTopView();

        System.out.println();
        System.out.println("Bottom View of Tree:-");
        printBottomView();

        System.out.println();
        System.out.println("Diagonal View of Tree (left to right):-");
        printDiagonalViewLtr();
        
        System.out.println();
        System.out.println("Diagonal View of Tree (right to left):-");
        printDiagonalViewRtl();

        System.out.println();
        System.out.println("Boundary View of Tree (anticlock-wise):-");
        printBoundaryViewAcw();

        System.out.println();
        System.out.println("Boundary View of Tree (clock-wise):-");
        printBoundaryViewCw();

        System.out.println();
        int searchNode = 8;
        System.out.println("Tried searching for (" + searchNode + "):-");
        int level = searchNode(searchNode);
        if (level == -1) {
            System.out.println("(" + searchNode + ") not found in tree.");
        } else {
            System.out.println("(" + searchNode + ") found on level (" + (level + 1) + ") in the tree.");
        }
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

    public int getHeightOfTree() {
        return calculateHeightOfTree(root);
    }

    private int calculateHeightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int heightOfLeftSubTree = calculateHeightOfTree(root.left);
        int heightOfRightSubTree = calculateHeightOfTree(root.right);

        return ((heightOfLeftSubTree > heightOfRightSubTree) ? heightOfLeftSubTree : heightOfRightSubTree) + 1;
    }

    public void levelOrderTrav() {
        System.out.println("    Using Naive Approach: ");
        for (int level = 1; level <= getHeightOfTree(); level++) {
            printSpecificLevel(root, level);
        }

        System.out.println();
        // Using Queue
        System.out.println("    Using Queue: ");
        levelOrderUsingQueue();
    }

    public void printSpecificLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + ", ");
        } else {
            printSpecificLevel(root.left, level - 1);
            printSpecificLevel(root.right, level - 1);
        }
    }

    public void levelOrderUsingQueue() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + ", ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public void levelWiseTrav() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp == null) {
                if (queue.isEmpty()) break;
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(temp.data + ", ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public void printLeftView() {
        if (root == null) return;
        HashMap<Integer, Integer> leftViewList = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        leftViewList.put(0,root.data);
        int height = 1;
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp == null) {
                if (queue.isEmpty()) break;
                Node peek = queue.peek();
                if (peek != null) {
                    leftViewList.put(height,peek.data);
                    height++;
                }
                queue.add(null);
                continue;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        leftViewList.forEach((k,v) -> System.out.print(v + ", "));
    }

    public void printRightView() {
        if (root == null) return;
        HashMap<Integer, Integer> leftViewList = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int height = 0;
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp == null) {
                if (queue.isEmpty()) break;
                height++;
                queue.add(null);
                continue;
            }
            leftViewList.put(height,temp.data);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        leftViewList.forEach((k,v) -> System.out.print(v + ", "));
    }


    public void printTopView() {
        if (root == null) return;
        Map<Integer, Integer> topViewList = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            if (!topViewList.containsKey(temp.level)) {
                topViewList.put(temp.level, temp.node.data);
            }
            if (temp.node.left != null) {
                queue.add(new Pair(temp.node.left, temp.level-1));
            }
            if (temp.node.right != null) {
                queue.add(new Pair(temp.node.right, temp.level+1));
            }
        }
        topViewList.forEach((k,v) -> System.out.print(v + ", "));
    }

    public void printBottomView() {
        if (root == null) return;
        Map<Integer, Integer> bottomViewList = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            bottomViewList.put(temp.level, temp.node.data);
            if (temp.node.left != null) {
                queue.add(new Pair(temp.node.left, temp.level-1));
            }
            if (temp.node.right != null) {
                queue.add(new Pair(temp.node.right, temp.level+1));
            }
        }
        bottomViewList.forEach((k,v) -> System.out.print(v + ", "));
    }
    
    public void printDiagonalViewLtr() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            while (temp != null) {
                System.out.print(temp.data + ", ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                temp = temp.right;
            } 
        }
    }

    public void printDiagonalViewRtl() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            while (temp != null) {
                System.out.print(temp.data + ", ");
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                temp = temp.left;
            } 
        }
    }

    public void printBoundaryViewAcw() {
        if (root == null) return;
        // print left boundary
        Node temp = root;
        while (temp != null) {
            if (temp.left == null && temp.right == null) {
                break;
            }
            System.out.print(temp.data + ", ");
            if (temp.left != null) {
                temp = temp.left;
            } else if (temp.right != null) {
                temp = temp.right;
            }
        }

        // print leaf nodes
        printLeafNodesLtr(root);

        // print right boundary
        if (root.right == null) return;
        ArrayList<Integer> rightBoundaryNodes = new ArrayList<>();
        temp = root.right;
        while (temp != null) {
            if (temp.left == null && temp.right == null) {
                break;
            }
            rightBoundaryNodes.add(temp.data);
            if (temp.right != null) {
                temp = temp.right;
            } else if (temp.left != null) {
                temp = temp.left;
            }
        }
        for (int idx = rightBoundaryNodes.size() - 1; idx >= 0; idx--) {
            System.out.print(rightBoundaryNodes.get(idx) + ", ");
        }
        
    }

    public void printLeafNodesLtr(Node node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.print(node.data + ", ");    
            }
            printLeafNodesLtr(node.left);
            printLeafNodesLtr(node.right);
        }
    }

    public void printBoundaryViewCw() {
        // print right boundary
        Node temp = root;
        while (temp != null) {
            if (temp.left == null && temp.right == null) {
                break;
            }
            System.out.print(temp.data + ", ");
            if (temp.right != null) {
                temp = temp.right;
            } else if (temp.left != null) {
                temp = temp.left;
            }
        }

        // print leaf nodes
        printLeafNodesRtl(root);

        // print right boundary
        if (root.left == null) return;
        ArrayList<Integer> rightBoundaryNodes = new ArrayList<>();
        temp = root.left;
        while (temp != null) {
            if (temp.left == null && temp.right == null) {
                break;
            }
            rightBoundaryNodes.add(temp.data);
            if (temp.left != null) {
                temp = temp.left;
            } else if (temp.right != null) {
                temp = temp.right;
            }
        }
        for (int idx = rightBoundaryNodes.size() - 1; idx >= 0; idx--) {
            System.out.print(rightBoundaryNodes.get(idx) + ", ");
        }
    }

    public void printLeafNodesRtl(Node node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.print(node.data + ", ");    
            }
            printLeafNodesRtl(node.right);
            printLeafNodesRtl(node.left);
        }
    }

    // Complexity -> O(h) -> h is height of tree
    public Integer searchNode(int num) {
        return searchRecursively(root, num, 0);
    }

    public Integer searchRecursively(Node root, int num, int level) {
        if (root == null) return -1;
        if (root.data == num) return level;
        level++;
        if (num < root.data) {
            return searchRecursively(root.left, num, level);
        }
        return searchRecursively(root.right, num, level);
    }

    public void deleteNode(int num) {
        // TODO: Need to Implement
    }
}

class Pair {
    Node node;
    int level;

    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}