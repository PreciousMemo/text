package textfiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Draw the set enumeration tree of a set using Graphviz
 * @author Philippe Fournier-Viger, 2015
 */
public class DrawSetEnumerationTree{

 public static void main(String[] arg) throws IOException,
 InterruptedException {

 // This is the set of integers that we want to draw the powerset of
 String[] set = new String[] { "a", "b", "c", "d", "e"};

 // output file
 String output = "input.dot";

 // create the file
 BufferedWriter writer = new BufferedWriter(new FileWriter(output));
 writer.write("digraph mygraph{" + System.lineSeparator());
 writer.write(" node [shape=plaintext]" + System.lineSeparator());

 // We will generate all links between subsets with a depth first search
 recursive("\"{", set, 0, writer);
 // write end of file
 writer.write("}");
 writer.close();
 }

 private static void recursive(String currentPrefix, String[] set, int offset, BufferedWriter writer) throws IOException {
 String startVertex = currentPrefix + "}\"";
 
 for(int i=offset; i< set.length; i++) {
 String concatenate;
 if(offset == 0) {
 concatenate = currentPrefix + set[i]; 
 }else {
 concatenate = currentPrefix + "," + set[i];
 }
 String endVertex = concatenate + "}\"";
 writer.write(" " + startVertex + " -> " + endVertex);
 writer.write(System.lineSeparator());
 recursive(concatenate, set, i+1, writer);
 }
 }
}