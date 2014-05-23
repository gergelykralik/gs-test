package com.fiit.gs.test;

import com.fiit.gs.test.reader.Reader;
import com.fiit.gs.test.reader.SeqReader;
import com.fiit.gs.test.sample.MySimpleGraph;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javafx.util.Pair;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 *
 * @author Gergely Kralik
 */
public class BFSTest2 {

    public void bfs(Graph g, String[] seq, int hops) {
       
        
//        MySimpleGraph simpleGraph = new MySimpleGraph();
//        g = simpleGraph.getGraph();

        ArrayList<Long> times = new ArrayList<>();
        long max = 0;
        
        for(String s : seq) {
            
            long startTime = System.currentTimeMillis();
        
            
            Node source = g.getNode(s);
        
            Map<Node, Integer> dist = new HashMap<>();
            Queue<Pair<Node,Integer>> q = new ConcurrentLinkedQueue<>();

            Pair root = new Pair(source, 0);
            q.add(root);

            while(!q.isEmpty()) {
                Pair cur = q.poll();
                Node n = (Node)cur.getKey();
                Integer depth = (Integer)cur.getValue();

                if(depth > hops) {
                    break;
                }

                if(!dist.containsKey(n)) {
                    dist.put(n, depth);
                } else {
                    continue;
                }

                Iterator<Node> iter = n.getNeighborNodeIterator();
                depth++;
                while(iter.hasNext()) {
                    Node i_act = iter.next();
                    if(!dist.containsKey(i_act)) {
                        Pair act = new Pair(i_act, depth);
                        q.add(act);
                    }
                }
            }
            
            long endTime = System.currentTimeMillis();
        
            times.add(endTime - startTime);
            if(max<(endTime - startTime)) {
                max = (endTime - startTime);
            }
            
        }
        
        int i = 0;
        long all = 0;
        for(long l : times) {
            all += l;
            i++;
        }
        
        System.out.println("BFS ("+hops+") Time avg: " + ((all/i)) + " ms.");
        System.out.println("BFS ("+hops+") Time max: " + (max) + " ms.");
    }
    
}
