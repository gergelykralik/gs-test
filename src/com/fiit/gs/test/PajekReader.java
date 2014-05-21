package com.fiit.gs.test;

import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;

/**
 * Sample code from http://graphstream-project.org/doc/Tutorials/Reading-files-using-FileSource_1.0/
 * @author Gergely Kralik
 */
public class PajekReader {

    public Graph readPajekFile(String path) throws IOException {
        String filePath = path;
        Graph g = new DefaultGraph("g");
        FileSource fs = FileSourceFactory.sourceFor(filePath);
        
        fs.addSink(g);
        
        try {
            fs.begin(filePath);

            while (fs.nextEvents()) {
                // Optionally some code here ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fs.end();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fs.removeSink(g);
        }
        
        return g;
    }

}
