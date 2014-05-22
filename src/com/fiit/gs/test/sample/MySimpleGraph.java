package com.fiit.gs.test.sample;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *            \
 *             6
 *           / | \
 *          9  8  7
 * Simple graph
 *
 * @author Gergely Kralik
 */
public class MySimpleGraph {

    Graph g;
    
    public MySimpleGraph() {
        g = new DefaultGraph("g");

        g.addNode("1");
        g.addNode("2");
        g.addNode("3");
        g.addNode("4");
        g.addNode("5");
        g.addNode("6");
        g.addNode("7");
        g.addNode("8");
        g.addNode("9");
        
        g.addEdge("E_1", "1", "2");
        g.addEdge("E_2", "1", "3");

        g.addEdge("E_3", "2", "4");
        g.addEdge("E_4", "2", "5");

        g.addEdge("E_5", "5", "6");
        
        g.addEdge("E_6", "6", "9");
        g.addEdge("E_7", "6", "8");
        g.addEdge("E_8", "6", "7");
    }
    
    public Graph getGraph() {
        return g;
    }
}
