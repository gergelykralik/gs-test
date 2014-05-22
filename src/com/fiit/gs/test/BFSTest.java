/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fiit.gs.test;

import java.io.File;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 *
 * @author Gergely
 */
public class BFSTest {
    
     public void bfs(File edges, File nodeSeq) {
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
        
        long time = System.currentTimeMillis();
        
        g.getNode("1");
        
     }
}
