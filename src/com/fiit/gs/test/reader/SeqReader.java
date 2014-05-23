package com.fiit.gs.test.reader;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reader for the node sequence files
 * @author Gergely Kralik
 */
public class SeqReader {

    public String[] read(File file) throws FileNotFoundException, IOException {
        
//        System.out.println("SequenceReader started");
        String[] sequence;
        StringBuilder sb = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(
                                new FileInputStream(file))));

        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line)
                    .append(",");
        }

        sequence = sb.toString().split(",");
//        System.out.println("SequenceReader end");
        return sequence;
    }
}
