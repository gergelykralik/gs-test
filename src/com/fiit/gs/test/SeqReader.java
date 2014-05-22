/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fiit.gs.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Gergely
 */
public class SeqReader {
    
    public String[] read(File file) throws FileNotFoundException, IOException {
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
        return sequence;
    }
}
