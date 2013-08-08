package utils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author jtan
 * @version 8/8/13
 */

public class Node {

    private int data;
    private int height;
    private NodeState state = NodeState.NotVisited;
    private Node left, right, top, bottom;

    public Node(int data) {
        this.data = data;
    }

    public List<Node> getAdjacentNodes() {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(left);
        nodes.add(right);
        nodes.add(top);
        nodes.add(bottom);

        return nodes;
    }

    public int getData() {
        return data;
    }

    public void setData(int data)  {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public NodeState getState() {
        return state;
    }

    public void setState(NodeState state) {
        this.state = state;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Node getBottom() {
        return bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }
}
