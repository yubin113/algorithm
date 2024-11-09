import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int N;

    static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        br  = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        Node head = new Node('A', null, null);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, value, left, right);

        }

        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);
        sb.append("\n");

        System.out.println(sb);
    }

    static void insertNode(Node temp, char root, char left, char right){
        //temp가 root 노드이면
        if(temp.value == root){
            //.이면 자식노드가 없어서 null로 지정하고 있으면 새로운 노드로 자식 생성
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = right == '.' ? null : new Node(right, null, null);
        }else{
            //temp가 root 노드가 아니라면
            if(temp.left != null){
                insertNode(temp.left, root, left, right);
            }
            if(temp.right != null){
                insertNode(temp.right, root, left, right);
            }
        }
    }

    public static void preOrder(Node node) {
        if(node ==null) return;
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node ==null) return;
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}
