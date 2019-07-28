package graphdsa;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a
 * list of its neighbors.
 */
public class CloneGraph {
    static class UndirectedGraphNode {

        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        Map<UndirectedGraphNode, UndirectedGraphNode> copyNodes = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> bfsQueue = new LinkedList<>();
        copyNodes.put(node, newNode);
        bfsQueue.add(node);
        while (!bfsQueue.isEmpty()){
            UndirectedGraphNode current = bfsQueue.poll();
            for (UndirectedGraphNode adjacent : current.neighbors){
                if (!copyNodes.containsKey(adjacent)){
                    bfsQueue.add(adjacent);
                    newNode = new UndirectedGraphNode(adjacent.label);
                    copyNodes.put(adjacent, newNode);
                    copyNodes.get(current).neighbors.add(newNode);
                }
                else {
                    copyNodes.get(current).neighbors.add(copyNodes.get(adjacent));
                }
            }
        }
        return copyNodes.get(node);
    }

}
