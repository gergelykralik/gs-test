package com.fiit.gs.test;

import com.fiit.gs.test.reader.Reader;
import com.fiit.gs.test.reader.SeqReader;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 * Dijkstra test
 *
 * @author Gergely Kralik
 */
public class DijkstraTest {

    /**
     * Dijkstra
     * @throws java.io.IOException
     */
    public void dijkstra(File edges, File nodeSeq) throws IOException {
        
        long initStart = System.currentTimeMillis();
        
        Reader r = new Reader();
        SeqReader sr = new SeqReader();
        
        Graph g = new DefaultGraph("g");
        
        try {
            g = r.readFile(edges);
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        String[] seq = new String[1];
        try {
            seq = sr.read(nodeSeq);
        } catch(IOException e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
        
        long startTime = System.currentTimeMillis();
        
        Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "length");
        dijkstra.init(g);

        for(int i = 0; i < seq.length; i+=2) {
            
            dijkstra.setSource(g.getNode(seq[i]));
            dijkstra.compute();

            // Print all the shortest paths between 1 and 100
//            Iterator<Path> pathIterator = dijkstra.getAllPathsIterator(g
//                    .getNode(seq[i+1]));
//            while (pathIterator.hasNext()) {
//                System.out.println(pathIterator.next());
//            }
            
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Dijkstra Time: " + ((endTime - startTime)) + " ms.");
        System.out.println("Dijkstra Time with init: " + ((endTime - initStart)) + " ms.");
    }

}
