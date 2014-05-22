package com.fiit.gs.test;

import com.fiit.gs.test.reader.Reader;
import com.fiit.gs.test.reader.SeqReader;
import com.fiit.gs.test.sample.MySimpleGraph;
import java.io.File;
import java.io.IOException;
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
public class BFSTest {

    public void bfs(File edges, File nodeSeq, int hops) {
        
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
        
//        MySimpleGraph simpleGraph = new MySimpleGraph();
//        g = simpleGraph.getGraph();

        for(String s : seq) {
            
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
            
        }
        
        long endTime = System.currentTimeMillis();
              
        System.out.println("BFS Time (" + hops + " hops): " + (endTime - startTime) + " ms.");
        System.out.println("BFS Time (" + hops + " hops) with init: " + (endTime - initStart) + " ms.");
        
    }
    
}
