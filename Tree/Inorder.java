import java.util.Stack;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
    }

}

public class Inorder {
    private static void inorderUsingRecursion(Node root) {
        if(root==null) {
            return;
        }
        inorderUsingRecursion(root.left);
        System.out.print(root.data + " ");
        inorderUsingRecursion(root.right);
    }

    private static void iterativeInorder(Node root) {
        if(root==null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(true) {
            if(root!=null) {
                stack.push(root);
                root = root.left;
            } else {
                if(stack.empty()) {
                    return;
                }
                Node node = stack.pop();
                System.out.print(node.data + " ");
                root = node.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.left.right.right = new Node(8);

        System.out.println("----Inorder using recursion----");
        inorderUsingRecursion(root);
        System.out.println("\n----Inorder using iterative----");
        iterativeInorder(root);
    }
}
