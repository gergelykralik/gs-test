package com.fiit.gs.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 * Dijkstra test
 *
 * @author Gergely Kralik
 */
public class DijkstraTest {

    /**
     * Dijktra
     * @throws java.io.IOException
     */
    public void dijkstra(File f) throws IOException {
        Reader r = new Reader();
        Graph g = new DefaultGraph("g");
        try {
            g = r.readFile(f);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        long time = System.currentTimeMillis();
        
        Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "length");
        dijkstra.init(g);
//        dijkstra.setSource(g.getNode("1"));
//        dijkstra.compute();

//        for (Node node : g) {
//            System.out.printf("%s->%s:%10.2f%n", dijkstra.getSource(), node,
//                    dijkstra.getPathLength(node));
//        }

//        for (Node node : dijkstra.getPathNodes(g.getNode("2"))) {
//            node.addAttribute("ui.style", "fill-color: blue;");
//        }

        // Color in red all the edges in the shortest path tree
//        for (Edge edge : dijkstra.getTreeEdges()) {
//            edge.addAttribute("ui.style", "fill-color: red;");
//        }

        // Print the shortest path from A to B
//        System.out.println(dijkstra.getPath(g.getNode("100")));

        // Build a list containing the nodes in the shortest path from A to B
        // Note that nodes are added at the beginning of the list
        // because the iterator traverses them in reverse order, from B to A
//        List<Node> list1 = new ArrayList<Node>();
//        for (Node node : dijkstra.getPathNodes(g.getNode("2"))) {
//            list1.add(0, node);
//        }

        // A shorter but less efficient way to do the same thing
//        List<Node> list2 = dijkstra.getPath(g.getNode("2")).getNodePath();

        // cleanup to save memory if solutions are no longer needed
//        dijkstra.clear();

        // Now compute the shortest path from A to all the other nodes
        // but taking the number of nodes in the path as its length
        dijkstra = new Dijkstra(Dijkstra.Element.NODE, null, null);
        dijkstra.init(g);
        dijkstra.setSource(g.getNode("1"));
        dijkstra.compute();

        // Print the lengths of the new shortest paths
        for (Node node : g) {
            System.out.printf("%s->%s:%10.2f%n", dijkstra.getSource(), node,
                    dijkstra.getPathLength(node));
        }

        // Print all the shortest paths between 1 and 100
        Iterator<Path> pathIterator = dijkstra.getAllPathsIterator(g
                .getNode("100"));
        while (pathIterator.hasNext()) {
            System.out.println(pathIterator.next());
        }
    
        System.out.println("Time: " + ((System.currentTimeMillis() - time)) + " ms.");
    }

}
