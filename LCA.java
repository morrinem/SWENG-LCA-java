public class LCA {
    public static void main(String args[])
    {
        Node a = new Node(1, null, null);
        Node b = new Node(2, a, null);
        Node c = new Node(3, null, null);
        Node d = new Node(4, b, c);
        Node e = new Node(5, null, null);
        Node f = new Node(6, null, null);
        Node g = new Node(7, e, f);
        Node h = new Node(8, null, null);
        Node i = new Node(9, g, h);
        Node j = new Node(10, d, i);
        //j is the root node
        /*
        10
        |       |
        4       9
        |   |   |   |
        2   3   7   8
        |       | |
        1       5 6
        */
        Node ans1 = findLCA(j, a, e);
        Node ans2 = findLCA(j, a, b);
        Node ans3 = findLCA(j, e, f);
        Node ans4 = findLCA(j, f, h);
        System.out.println(ans1.data);
        System.out.println(ans2.data);
        System.out.println(ans3.data);
        System.out.println(ans4.data);
        //answer data = 10, 2, 7, 9 correctly
    }

    static Node findLCA(Node root, Node a, Node b)
    {
        if (root == null || a == null || b == null) return null;
        if (root.data == a.data || root.data == b.data) return root;

        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }
}

class Node {
    public Node left, right;
    public Object data;
    Node (Object data, Node left, Node right)
    {
        if (left != null) this.left = left;
        if (right != null) this.right = right;
        this.data = data;
    }
}