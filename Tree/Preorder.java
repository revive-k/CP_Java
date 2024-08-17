import java.util.Stack;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
    }

}

public class Preorder {

    private static void preorderUsingRecursion(Node root) {
        if(root==null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderUsingRecursion(root.left);
        preorderUsingRecursion(root.right);
    }

    private static void iterativePreorder(Node root) {
        if(root==null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if(node.right!=null) {
                stack.push(node.right);
            }
            if(node.left!=null) {
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        //Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);

        System.out.println("-----Preorder using recursion-----");
        preorderUsingRecursion(root);
        System.out.println();
        System.out.println("-----Preorder using iterative method-----");
        iterativePreorder(root);
    }
}
