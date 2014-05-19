package com.fiit.gs.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File reader class to process the graphs from file
 * @author Gergely Kralik
 */
public class Reader {

    /**
     * readFile
     * @param file File
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void readFile(File file) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(
                                new FileInputStream(file))));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("\t");
            Integer id1 = Integer.parseInt(tokens[0]);
            Integer id2 = Integer.parseInt(tokens[1]);
            System.out.println(id1 + " " + id2);
        }
    }
}
