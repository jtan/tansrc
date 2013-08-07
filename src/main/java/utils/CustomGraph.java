package utils;
import java.util.TreeSet;

/**
 *  Custom graph where each node can have four adjacent nodes (top, bottom, left, right) connected by edges.
 *
 */
public class CustomGraph {
    private Node head;
    private TreeSet<Node> nodes;

    public CustomGraph(Node head) {
        this.head = head;
    }

    public TreeSet<Node> getNodes() {
        return nodes;
    }
}