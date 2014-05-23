package com.fiit.gs.test;

import com.fiit.gs.test.reader.Reader;
import com.fiit.gs.test.reader.SeqReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
public class DijkstraTest2 {

    /**
     * Dijkstra
     * @throws java.io.IOException
     */
    public void dijkstra(Graph g, String[] seq) throws IOException {
              
        ArrayList<Long> times = new ArrayList<>();
        long max = 0;
        
        for(int i = 0; i < seq.length; i+=2) {
            
            long startTime = System.currentTimeMillis();
            
            Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "length");
            dijkstra.init(g);

        
            
            dijkstra.setSource(g.getNode(seq[i]));
            dijkstra.compute();

            // Print all the shortest paths between 1 and 100
//            Iterator<Path> pathIterator = dijkstra.getAllPathsIterator(g
//                    .getNode(seq[i+1]));
//            while (pathIterator.hasNext()) {
//                System.out.println(pathIterator.next());
//            }
            
            long endTime = System.currentTimeMillis();
        
            times.add(endTime - startTime);
            if(max<(endTime - startTime)) {
                max = (endTime - startTime);
            }
            
//            System.out.println("Dijkstra Time: " + ((endTime - startTime)) + " ms.");
        }
//        System.out.println(times.size());
        int i = 0;
        long all = 0;
        for(long l : times) {
            all += l;
            i++;
        }
        
        System.out.println("Dijkstra Time avg: " + ((all/i)) + " ms.");
        System.out.println("Dijkstra Time max: " + (max) + " ms.");
    }

}
