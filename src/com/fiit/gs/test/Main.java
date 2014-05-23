package com.fiit.gs.test;

import com.fiit.gs.test.reader.Reader;
import com.fiit.gs.test.reader.SeqReader;
import java.io.File;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 *
 * @author Gergely Kralik
 */
public class Main {
    
    public static void main(String[] args) throws IOException{
        
//        experiment("ga/rnd-graph-10000-pl.txt","ga/seq/seq4N-10000.txt");
        
        // spustenie experimentu sekvencne
        
        experiment("ga/rnd-graph-100-pl.txt","ga/seq/seq4N-100.txt");
        experiment("ga/rnd-graph-500-pl.txt","ga/seq/seq4N-500.txt");
//        experiment("ga/rnd-graph-1000-pl.txt","ga/seq/seq4N-1000.txt");
//        experiment("ga/rnd-graph-5000-pl.txt","ga/seq/seq4N-5000.txt");
//        experiment("ga/rnd-graph-10000-pl.txt","ga/seq/seq4N-10000.txt");
//        experiment("ga/rnd-graph-50000-pl.txt","ga/seq/seq4N-50000.txt");
        
        
        experiment("ga/rnd-graph-100-smallD.txt","ga/seq/seq4N-100.txt");
        experiment("ga/rnd-graph-500-smallD.txt","ga/seq/seq4N-500.txt");
//        experiment("ga/rnd-graph-1000-smallD.txt","ga/seq/seq4N-1000.txt");
//        experiment("ga/rnd-graph-5000-smallD.txt","ga/seq/seq4N-5000.txt");
//        experiment("ga/rnd-graph-10000-smallD.txt","ga/seq/seq4N-10000.txt");
//        experiment("ga/rnd-graph-50000-smallD.txt","ga/seq/seq4N-50000.txt");
        
        
        // Fail
//        experiment("ga/rnd-graph-100000-smallD.txt","ga/seq/seq4N-100000.txt");
//        
//        experiment("ga/rnd-graph-100000-pl.txt","ga/seq/seq4N-100000.txt");

        // -- Na testovanie celkoveho casu (vid cas_full.pdf)
                
//        File edges = new File("ga/rnd-graph-100-smallD.txt");
//        
//        File nodeSeq = new File("ga/seq/seq4N-100.txt");
        
        // BFS test 2 hops
//        BFSTest bf = new BFSTest();
//        bf.bfs(edges, nodeSeq, 2);
        
        // BFS test 3 hops
//        bf.bfs(edges, nodeSeq, 3);
        
        // Dijkstra test
//        DijkstraTest di = new DijkstraTest();
//        try {
//            di.dijkstra(edges, nodeSeq);
//        }catch(IOException e) {
//            System.err.println(e.getMessage());
//        }
    }

    
    public static void experiment(String f1, String f2) throws IOException {
        System.out.println("Experiment: " + f1);
        File fi1 = new File(f1);
        File fi2 = new File(f2);
        
        Reader r = new Reader();
        SeqReader sr = new SeqReader();

        Graph g = new DefaultGraph("g");

        try {
            g = r.readFile(fi1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        
        String[] seq = new String[1];
        try {
            seq = sr.read(fi2);
        } catch(IOException e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
        
        /////////////////////////
        
        DijkstraTest2 djk = new DijkstraTest2();
        djk.dijkstra(g, seq);
        
        BFSTest2 bfs = new BFSTest2();
        bfs.bfs(g, seq, 2);
        
        bfs.bfs(g, seq, 3);
    }
}
