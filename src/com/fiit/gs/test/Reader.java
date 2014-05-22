package com.fiit.gs.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.graphstream.graph.EdgeRejectedException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;

/**
 * File reader class to process the graphs from file
 * @author Gergely Kralik
 */
public class Reader {

    /**
     * readFile
     * @param file File
     * @return Graph
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Graph readFile(File file) throws FileNotFoundException, IOException {

        Graph g = new DefaultGraph("g");
        
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(
                                new FileInputStream(file))));

        String line;
        long l = 1;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("\t");
            Integer id1 = Integer.parseInt(tokens[0]); // vertex1
            Integer id2 = Integer.parseInt(tokens[1]); //vertex2
            
//            System.out.println(id1 + " " + id2);
            if(g.getNode(id1+"") == null)
                g.addNode(id1+"");
            if(g.getNode(id2+"") == null)
                g.addNode(id2+"");
            try {
                g.addEdge("E_"+l, id1+"", id2+"");
            } catch(EdgeRejectedException e) {
                System.err.println(e.getMessage());
            }
            l++;
        }

        return g;
    }
}
