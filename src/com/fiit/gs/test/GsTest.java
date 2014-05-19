package com.fiit.gs.test;

import java.io.File;
import java.io.IOException;

/**
 * Tests main class
 * @author Gergely Kralik
 */
public class GsTest {

    /**
     * Main method
     * @param args 
     */
    public static void main(String[] args) {
        Reader r = new Reader();
        File f = new File("ga/rnd-graph-100-smallD.txt");
        try {
            r.readFile(f);
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
