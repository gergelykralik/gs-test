package com.fiit.gs.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 * Tests main class
 *
 * @author Gergely Kralik
 */
public class GsTest {

    /**
     * Main method
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        File f = new File("ga/rnd-graph-100-smallD.txt");
        Graph g = new DefaultGraph("g");
        try {
            g = r.readFile(f);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        g.display();
        long time = System.currentTimeMillis();

        Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, "weight", "length");
        dijkstra.setSource(g.getNode("1"));
        dijkstra.init(g);
        dijkstra.compute();

        System.out.println(dijkstra.getPath(g.getNode("5")));
        Iterator<Node> nodes;
        nodes = dijkstra.getPathNodesIterator(g.getNode("5"));

        System.out.println("Iterator: ");
        while (nodes.hasNext()) {
            System.out.print(nodes.next().getId());
        }
        System.out.println("\nTime: " + (System.currentTimeMillis() - time) + " ms");

//        String path = "ga/rnd-graph-100-smallD.txt";
//        PajekReader pj = new PajekReader();
//        
//        Graph g = pj.readPajekFile(path);
//        System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
//        Viewer viewer = g.display();
    }

}
