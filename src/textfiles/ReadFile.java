package textfiles;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
    private final String path;
    public static int numberOfLine;
    String[] OpenFile;
    public ReadFile(String file_path){
        path = file_path;
    }
    public String[] OpenFile() throws IOException{
        
        FileReader fr = new FileReader(path);
        String[] textData;
        try (BufferedReader textReader = new BufferedReader(fr)) {
            numberOfLine = readLine();
            textData = new String[numberOfLine];
            int i;
            for (i=0; i < numberOfLine; i++) {
                textData[ i ] = textReader.readLine();
            }
        }
        
        return textData;
    }
    
    int readLine() throws IOException{
        
        FileReader file_to_read = new FileReader(path);
        int numberOfLines;
        try (BufferedReader bf = new BufferedReader(file_to_read)) {
            String aLine;
            numberOfLines = 0;
            while ((aLine = bf.readLine()) != null) {
                numberOfLines++;
            }
        }
        return numberOfLines;
    }
}


