package utils;
import java.util.TreeSet;

/**
 *  Custom graph where each node can have four adjacent nodes (top, bottom, left, right) connected by edges.
 *
 * @author jtan
 * @version 8/8/13
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