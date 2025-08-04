import java.io.*;
import java.util.*;

class Solution {
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        //노드 배열
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }
        
        //정렬
        Arrays.sort(nodes);
        
        //트리 만들기(노드 넣기)
        Node head = nodes[0];
        for(int i = 1; i < nodes.length; i++){
            insertNode(head, nodes[i]);
        }
        
        //전위순회, 후위순회
        preOrder(head);
        postOrder(head);
        
        //결과 넣기
        for(int i = 0; i < nodeinfo.length; i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        
        return answer;
    }
   
    //노드 삽입
    public void insertNode(Node parent, Node child){
        //왼쪽
        if(child.x < parent.x){
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        }else{
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    //전위순회
    public void preOrder(Node node){
        if(node == null) return;
        //가운데 -> 왼 -> 오
        pre.add(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    //후위순회
    public void postOrder(Node node){
        if(node == null) return;
        //왼 -> 오 -> 가운데
        postOrder(node.left);
        postOrder(node.right);
        post.add(node.value);
    }
    
}
class Node implements Comparable<Node>{
    int value;
    int x,y;
    Node left, right;
    public Node(int value, int x, int y, Node left, Node right){
        this.value = value;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int compareTo(Node n){
        if(n.y == this.y) return this.x - n.x;
        return n.y - this.y;
    }
}