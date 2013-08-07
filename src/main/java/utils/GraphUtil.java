package utils;
import java.lang.NullPointerException;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Utility to work with a custom graph.
 */
public class GraphUtil {

    public static boolean hasConnectingRoute(CustomGraph graph, Node sourceNode, Node targetNode) throws NullPointerException {
        if (graph == null || sourceNode == null || targetNode  == null) throw new NullPointerException();

        initGraphState(graph);

        // init queue to be used for BFS
        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.add(sourceNode);

        int targetData = targetNode.getData();

        Node currentNode;

        while (!nodeQueue.isEmpty()) {
            currentNode = nodeQueue.remove();
            currentNode.setState(NodeState.Visiting);

            for (Node n : currentNode.getAdjacentNodes()) {
                if (n.getData() == targetData) {
                    return true;
                } else {
                    nodeQueue.add(n);
                }
            }

            currentNode.setState(NodeState.Visited);

        }

        return false;
    }

    private static void initGraphState(CustomGraph graph) {
        for (Node n : graph.getNodes()) {
            n.setState(NodeState.NotVisited);
        }
    }
}