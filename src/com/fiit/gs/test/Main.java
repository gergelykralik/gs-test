package com.fiit.gs.test;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Gergely Kralik
 */
public class Main {
    
    public static void main(String[] args) {
        
        File edges = new File("ga/rnd-graph-500000-smallD.txt");
        
        File nodeSeq = new File("ga/seq/seq4N-500000.txt");
        
        // BFS test 2 hops
        BFSTest bf = new BFSTest();
        bf.bfs(edges, nodeSeq, 2);
        
        // BFS test 3 hops
        bf.bfs(edges, nodeSeq, 3);
        
        // Dijkstra test
        DijkstraTest di = new DijkstraTest();
        try {
            di.dijkstra(edges, nodeSeq);
        }catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
