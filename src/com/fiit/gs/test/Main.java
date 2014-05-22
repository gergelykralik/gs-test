package com.fiit.gs.test;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Gergely Kralik
 */
public class Main {
    
    public static void main(String[] args) {
        
        File edges = new File("ga/rnd-graph-100-smallD.txt");
        
        File nodeSeq = new File("ga/seq/seq4N-100.txt");
        
        // Dijkstra test
        DijkstraTest di = new DijkstraTest();
        try {
            di.dijkstra(edges);
        }catch(IOException e) {
            System.err.println(e.getMessage());
        }
        
        // BFS test
        BFSTest bf = new BFSTest();
        bf.bfs(edges, nodeSeq);
    }
}
